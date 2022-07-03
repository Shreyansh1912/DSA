class Solution {
    public int totalNQueens(int n) {
     //List<List<String>> answer = new ArrayList<>();
        int[] answer = {0};
        char[][] board = new char[n][n];
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
            
          nQueens(board, 0, n, answer);
        // return answer.size();
        return answer[0];
    }
    
    private void nQueens(char[][] board, int currentRow, int n,  int[] answer){
        
        if(currentRow == n){
           // answer.add(constructAns(board, n));
            answer[0] += 1;
        return;
        }
        
        for(int currentCol = 0; currentCol < n; currentCol++){    // four Columns have to put queen
            
            if(isValid(board, currentRow, currentCol, n)){
                board[currentRow][currentCol] = 'Q';
            nQueens(board, currentRow + 1, n, answer);
            board[currentRow][currentCol] = '.'; //backtrack
           }
        }
        return;
    }
 //    This part is used in N-Queen I
//     private List<String> constructAns(char[][] board, int n){
//         List<String> current = new ArrayList<>();
        
//         for(int i = 0; i < n; i++){
//             String currentRowString = "";
//          for(int j = 0; j < n; j++)                        
//              currentRowString += board[i][j];
            
//          current.add(currentRowString);   
//         }
//         return current;
//     }
    
    private boolean isValid(char[][] board, int currentRow, int currentCol, int n){
        return isRowValid(board, currentRow, n) && isColValid(board, currentCol, n)
            && isDiagonalValid(board, currentRow, currentCol, n);
    }
    
    private boolean isRowValid(char[][] board, int currentRow, int n){
        
        for(int currentCol = 0; currentCol < n; currentCol++){
            
            if(board[currentRow][currentCol] == 'Q')
                return false;
        }
        return true;
    }
    
    private boolean isColValid(char[][] board, int currentCol, int n){
        
        for(int currentRow = 0; currentRow < n; currentRow++){
            
            if(board[currentRow][currentCol] == 'Q')
                return false;
        }
        return true;
    }
    
    private boolean isDiagonalValid(char[][] board, int currentRow,  int currentCol, int n){
        
        // left-Up diagonal
        int x = currentRow;
        int y = currentCol;
        
        while(x >= 0 && y >= 0){
            if(board[x][y] == 'Q')
                return false;
            x-=1;
            y-=1;
        }
        //right-Up diagonal
         x = currentRow;
         y = currentCol;
        
        while(x >= 0 && y < n){
            if(board[x][y] == 'Q')
                return false;
            x-=1;
            y+=1;
        }
        return true;
    }
}
