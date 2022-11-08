class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int largestOverlap = 0;
        int N1 = img1.length;
        int N2 = img2.length;
                                                          //TC:O(N^4) SC:O(1)
        for(int row = -N1+1; row < N1; row++){
            for(int col = -N2+1; col < N1; col++){
                largestOverlap = Math.max(largestOverlap, overlapOnes(img1, img2, row, col));
            }
        }
        return largestOverlap;
    }
    private int overlapOnes(int[][] img1, int[][] img2, int rowOff, int colOff){
        
        int count=0;
        
        for(int row = 0; row < img1.length; row++){
            for(int col = 0; col < img1[0].length; col++){
                
                if((row + rowOff < 0 || row + rowOff >= img1.length) || (col + colOff < 0 || col + colOff >= img1[0].length))
                   continue;
                   
                if(img1[row][col] + img2[row+rowOff][col+colOff] == 2)
                   count++;
            }
        }
      return count;
    }
}
