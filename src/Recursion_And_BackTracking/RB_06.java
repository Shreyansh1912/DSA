class Solution {
    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0, board.length);
        return;
    }
    private boolean sudokuSolver(char[][] board, int currentRow, int currentCol, int n){
        
        if(currentRow == n) // I am present at last index of board, means we complete sudoku so return
            return true;
        
        int nextRowIndex = -1;
        int nextColIndex = -1;
        
        if(currentCol != n-1){
            nextRowIndex = currentRow;
            nextColIndex = currentCol + 1;
        } else{
            nextRowIndex = currentRow + 1;
            nextColIndex = 0;
        }
        
        if(board[currentRow][currentCol] != '.')
            return sudokuSolver(board, nextRowIndex, nextColIndex, n);
        
        for(char currentVal = '1'; currentVal <= '9'; currentVal++){
            
            if(isValid(board, currentRow, currentCol, currentVal, n)){
                board[currentRow][currentCol] = currentVal;
                
               if(sudokuSolver(board, nextRowIndex, nextColIndex, n))
                  return true;
                
                board[currentRow][currentCol] = '.';
            }
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int currentRow, int currentCol, char currentVal, int n){
        return isRowValid(board, currentRow, n, currentVal) && 
            isColValid(board, currentCol, currentVal, n) && 
            isSubGridValid(board, currentRow, currentCol, currentVal, n);
    }
    
    private boolean isRowValid(char[][] board, int currentRow, int n, char currentVal){
        
        for(int currentCol = 0; currentCol < n; currentCol++){
            
              if(board[currentRow][currentCol] == currentVal)
                  return false;
        }
      return true;
    }
    
     private boolean isColValid(char[][] board, int currentCol, char currentVal, int n){
        
        for(int currentRow = 0; currentRow < n; currentRow++){
            
              if(board[currentRow][currentCol] == currentVal)
                  return false;
        }
      return true;
    }
    
    private boolean isSubGridValid(char[][] board, int currentRow, int currentCol, char currentVal, int n){
        int startRowIndex = 3 * (currentRow / 3); // find the starting point of subGrid
        int startColIndex = 3 * (currentCol / 3); // find the starting point of subGrid
        
        for(int i = startRowIndex; i <= startRowIndex+2; i++)   // traverse  by +2
            for(int j = startColIndex; j <= startColIndex+2; j++){
                
                if(board[i][j] == currentVal)
                    return false;
        }
        return true;
    }
}
