class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    if(k <= 1) return 0;
        
        int c=0; 
        int left=0;
        int prod = 1;
        
        for(int r = 0; r < nums.length; r++){
            prod *= nums[r];
            
            while(prod >= k){
                prod /= nums[left++];
            }
            c += r-left+1;
        }
        return c;
    }
}
