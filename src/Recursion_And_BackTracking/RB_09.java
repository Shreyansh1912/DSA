class Solution {
    
    public static final String[] KEYS_MAPPINGS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        
        if(digits.length() == 0) //corner case
            return answer;
        
        generateComs(digits, 0, "", answer);
        return answer;
    }
    private void generateComs(String digits, int currentIndex, String currentString, List<String> answer){
        if(currentIndex >= digits.length()){
            answer.add(currentString);
            return;
        }
        String letters = KEYS_MAPPINGS[digits.charAt(currentIndex) - '0'];
        
        for(int i = 0; i < letters.length(); i++){
            generateComs(digits, currentIndex+1, currentString + letters.charAt(i), answer);
        }
        return;
    }
}
