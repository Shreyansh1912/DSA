class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        generateAllCombs(s, 0, s.length()-1, new ArrayList<>(), result);
        return result;
    }
    private void generateAllCombs(String s, int start, int end, ArrayList<String> currentConf, List<List<String>> result){
        if(start > end){
            result.add(new ArrayList<String>(currentConf));
                return;
        }
        
        for(int i = start; i <= end; i++){
            String leftPart = s.substring(start, i+1);
            
            if(isPalindromic(leftPart)){
                currentConf.add(leftPart);
                generateAllCombs(s, i+1, end, currentConf, result);
                currentConf.remove(currentConf.size()-1);
            }
        }
        return;
    }
    private boolean isPalindromic(String s){
        int left = 0;
        int right = s.length()-1;
        
        while(left <= right){
            
            if(s.charAt(left) != s.charAt(right))
                return false;
            left += 1;
            right -= 1;
        }
        return true;
    }
}
