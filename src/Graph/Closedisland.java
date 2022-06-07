class ClosedIsland {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = 0;
        
        for(int currentCol = 0; currentCol < n; currentCol++){
            
            if(grid[0][currentCol] == 0)
                dfs(grid, 0, currentCol, m , n);
            
            if(grid[m-1][currentCol] == 0)
                dfs(grid, m-1, currentCol, m , n);
            }
        
        for(int currentRow = 0; currentRow < m; currentRow++){
            
            if(grid[currentRow][0] == 0)
                dfs(grid, currentRow, 0, m, n);
            
            if(grid[currentRow][n-1] == 0)
                dfs(grid, currentRow, n-1, m, n);
            }
        
        for(int currentRow = 0; currentRow < m; currentRow++)
            for(int currentCol = 0; currentCol < n; currentCol++){
                
                if(grid[currentRow][currentCol] == 0){
                    dfs(grid, currentRow, currentCol, m, n);
                    answer += 1;
                 }
          }
        return answer;
    }
    private void dfs(int[][] grid, int currentRow, int currentCol, int m, int n){
        if(currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n || grid[currentRow][currentCol] == 1)
           return;
        
        grid[currentRow][currentCol] = 1;
        dfs(grid, currentRow-1, currentCol, m, n);
        dfs(grid, currentRow+1, currentCol, m, n);
        dfs(grid, currentRow, currentCol-1, m, n);
        dfs(grid, currentRow, currentCol+1, m, n);
        return;
        
    }
}
