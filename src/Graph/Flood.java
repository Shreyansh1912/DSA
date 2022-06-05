class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
        if(grid[sr][sc] == newColor)
            return grid;
        
        dfs(grid, sr, sc, grid[sr][sc], newColor);
        return grid;
    }
    private void dfs(int[][] grid, int currentRow, int currentCol, int color, int newColor){
        
        if(currentRow >= grid.length || currentRow < 0 || currentCol >= grid[0].length 
          || currentCol < 0 || grid[currentRow][currentCol] != color)
           return;

       grid[currentRow][currentCol] = newColor;

       dfs(grid, currentRow-1, currentCol, color, newColor);
       dfs(grid, currentRow+1, currentCol, color, newColor);
       dfs(grid, currentRow, currentCol-1, color, newColor);
       dfs(grid, currentRow, currentCol+1, color, newColor);
       return;
    }
}
