class Solution {
    public int numIslands(char[][] grid) {
        int answer=0;
        int m=grid.length;
        int n=grid[0].length;
        
        for(int currentRow = 0; currentRow < m; currentRow++)
            for(int currentCol = 0; currentCol < n; currentCol++){
                
                if(grid[currentRow][currentCol] == '1'){
                    dfs(grid, currentRow, currentCol, m, n);
                    answer += 1;
                   }
            }
        return answer;
    }
   private void dfs(char[][] grid, int currentRow, int currentCol, int m, int n){
       if(currentRow >= m || currentRow < 0 || currentCol >= n || currentCol < 0 || grid[currentRow][currentCol] == '0')
           return;
       
       grid[currentRow][currentCol] = '0';
       
       dfs(grid, currentRow-1, currentCol, m, n);
       dfs(grid, currentRow+1, currentCol, m, n);
       dfs(grid, currentRow, currentCol-1, m, n);
       dfs(grid, currentRow, currentCol+1, m, n);
       return;
   } 
    
    
}
