class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        
        for(char c:s.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        int result = 0;
        boolean odd = false;
        
        for(int i: hm.values()){
            if(i % 2 == 0) result += i;
            else{
                odd = true;
                result += i-1;
            }
        }
        if(odd) result++;
        return result;
    }
}
