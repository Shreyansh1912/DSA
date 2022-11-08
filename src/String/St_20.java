class Solution {
    public int maxLength(List<String> arr) {
        List<String> answer = new ArrayList<>();
        int count = 0;
        
        answer.add("");
        for(String str:arr){
            if(!checkUniqueCharString(str)) continue;
            
            List<String> newListWithCurrString = new ArrayList<>();
            
            for(String candidate: answer){
                String temp = candidate + str;
                if(checkUniqueCharString(temp)){
                    newListWithCurrString.add(temp);
                    count = Math.max(count, temp.length());
                }
            }
            answer.addAll(newListWithCurrString);
        }
        return count;
    }
    private boolean checkUniqueCharString(String str){
        if(str.length() > 26) return false;
        
        int freq[] = new int[26];
        for(char ch:str.toCharArray()){
            freq[ch-'a']++;
            
            if(freq[ch-'a'] > 1)return false;
        }
        return true;
    }
}
