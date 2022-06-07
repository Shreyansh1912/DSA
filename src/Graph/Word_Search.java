class Word_Search {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for(int currentRow = 0; currentRow < m; currentRow++)
            for(int currentCol = 0; currentCol < n; currentCol++){
                
                if(board[currentRow][currentCol] == word.charAt(0))
                    if(dfs(board, currentRow, currentCol, 0, word, m, n))
                        return true;
            }
        return false;
    }
    private boolean dfs(char[][] board, int currentRow, int currentCol, int currentIndex, String word, int m, int n){
        
        if(currentIndex >= word.length())
            return true;
        
         if(currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n || 
            board[currentRow][currentCol] != word.charAt(currentIndex))
           return false;
        
        Character temp = board[currentRow][currentCol];
        board[currentRow][currentCol] = '.';
        
        boolean found = dfs(board, currentRow-1, currentCol, currentIndex+1, word, m, n) ||
            dfs(board, currentRow+1, currentCol, currentIndex+1, word, m, n) ||
            dfs(board, currentRow, currentCol-1, currentIndex+1, word, m, n) ||
            dfs(board, currentRow, currentCol+1, currentIndex+1, word, m, n);
        
        board[currentRow][currentCol] = temp;
        return found;
    }
}
