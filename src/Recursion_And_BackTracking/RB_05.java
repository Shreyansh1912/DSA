// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public ArrayList<String> findPath(int[][] grid, int n) {
        ArrayList<String> answer = new ArrayList<>();
        findAllPath(grid, 0, 0, n, "", answer);
        return answer;
    }
    private void findAllPath(int[][] grid, int currentRow, int currentCol, int n, String currentPath, ArrayList<String> answer){
        
        if(currentRow < 0 || currentRow >= n || currentCol < 0 || currentCol >= n || grid[currentRow][currentCol] <= 0)
           return;
           
        if(currentRow == n-1 && currentCol == n-1){
            answer.add(currentPath);
            return;
        } 
        grid[currentRow][currentCol] = -1;
        //print in lexographical order ---> D, L, R, U
        //Down move
        findAllPath(grid, currentRow+1, currentCol, n, currentPath+"D", answer);
        //Left Move
        findAllPath(grid, currentRow, currentCol-1, n, currentPath+"L", answer);
        //Right Move
        findAllPath(grid, currentRow, currentCol+1, n, currentPath+"R", answer);
        //Up Move
        findAllPath(grid, currentRow-1, currentCol, n, currentPath+"U", answer);
        
        grid[currentRow][currentCol] = 1;
        return;
    }
}
