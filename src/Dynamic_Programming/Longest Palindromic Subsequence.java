class Solution {
    public int longestPalindromeSubseq(String s) {
     return LengthOfLCS(s, new StringBuilder(s).reverse().toString(), 0, 0, s.length(), s.length(), new HashMap<String, Integer>());
    }
    private int LengthOfLCS(String s1, String s2, int i, int j, int m, int n, HashMap<String, Integer> memo){
        if(i >= m || j >= n)
          return 0;
        
        String currentKey = i + "-" + j;             //TC: O(m*n);  SC:O(m*n)

        if(memo.containsKey(currentKey))
         return memo.get(currentKey);

        int ans=0;

        if(s1.charAt(i) == s2.charAt(j))
          ans = 1 + LengthOfLCS(s1, s2, i+1, j+1, m, n, memo);          //TC: 2^Math.min(m, n) , SC: Math.min(n,m)
        else{
            int a = LengthOfLCS(s1, s2, i+1, j, m, n, memo);
            int b = LengthOfLCS(s1, s2, i, j+1, m, n, memo);
            ans = Math.max(a, b);
        }
        memo.put(currentKey, ans);
        return ans;        
    }
}
