class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col]);
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] < 0)
                    grid[i][j] = color;
                    
            }
        }
        return grid;
    }
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    
    private void dfs(int[][] grid, int row, int col, int clr){
       grid[row][col] = -clr;
        int count=0;
        
        for(int i=0; i<4; i++)
        {
            int rowDash = row + dirs[i][0];
            int colDash = col + dirs[i][1];
            
            if(rowDash < 0 || colDash < 0 || rowDash >= grid.length || 
               colDash >= grid[0].length || Math.abs(grid[rowDash][colDash])!= clr){
                continue;
            }
            count++;
        
            if(grid[rowDash][colDash] == clr){
                dfs(grid, rowDash, colDash, clr);
            }
        }
        if(count == 4){
            grid[row][col] = clr;
        }
        
    }
}
