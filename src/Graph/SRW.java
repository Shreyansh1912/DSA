class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));
        
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            
            if(rem.row == n-1 && rem.col == n-1){
                return rem.msf;
            }
            if(visited[rem.row][rem.col] == true){
                continue;
            }
            
            visited[rem.row][rem.col] = true;
            
            for(int i=0; i<4; i++){
              int rowDash = rem.row + dirs[i][0];
              int colDash = rem.col + dirs[i][1];
            
                 if(rowDash < 0 || colDash < 0 || rowDash >= n || colDash >= n || visited[rowDash][colDash] == true){
                     continue;
                  }
                pq.add(new Pair(rowDash, colDash, Math.max(rem.msf, grid[rowDash][colDash])));
            }
        }
        return 0;
    }
    class Pair implements Comparable<Pair>{
        int row;
        int col;
        int msf;
        
        Pair(int row, int col, int msf){
            this.row = row;
            this.col = col;
            this.msf = msf;
        }
        public int compareTo(Pair o){
            return this.msf - o.msf;
        }
    }
        
}
