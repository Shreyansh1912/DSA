class Solution {
    public int uniquePaths(int m, int n) {
        return totalWays(0, 0, m-1, n-1, new HashMap<>());
    }
    private int totalWays(int currentRow, int currentCol, int m, int n, HashMap<String, Integer> memo){
        if(currentRow == m-1 && currentCol == n-1)
           return 1;

        if(currentRow >= m || currentCol >= n)   
          return 0;

         String currentKey = currentRow + "-" + currentCol;

        if(memo.containsKey(currentKey))
          return memo.get(currentKey);

        int RightMove = totalWays(currentRow, currentCol+1, m, n, memo);
        int DownMove = totalWays(currentRow+1, currentCol, m, n, memo);  

        memo.put(currentKey, RightMove + DownMove);
        return memo.get(currentKey);
    }
}
