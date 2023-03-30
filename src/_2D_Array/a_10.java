class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        
        int n = matrix.length;          //TC: O(log2N) , SC:O(1)
        int m = matrix[0].length;
        
        int low = 0;
        int high = (n*m)-1;
        
        while(low <= high){
            int mid = (low + (high-low)/2);
            
            if(matrix[mid/m][mid%m] == target) return true;
            
            if(matrix[mid/m][mid%m] < target) {
                low = mid+1;
            } else{
                high = mid-1;
            } 
        }
        return false;
    }
}
