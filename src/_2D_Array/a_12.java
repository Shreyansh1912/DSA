class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length;
        int n = image[0].length;
        //TC: O(M*N)~ O(N), SC: O(1)
        for(int i=0; i<m; i++){
            for(int j=0; j<(n+1)/2; j++){
                int temp = image[i][j]^ 1;
                image[i][j] = image[i][n-j-1]^1;
                image[i][n-j-1] = temp;

            }
        }
        return image;
    }
}
