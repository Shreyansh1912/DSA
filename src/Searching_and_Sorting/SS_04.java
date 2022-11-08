class Solution {
    public int pivotIndex(int[] nums) {
        
        int OverAllSum=0;
        for(int i=0; i<nums.length; i++){
            OverAllSum += nums[i];
        }
        int leftSum = 0;
        int rightSum = OverAllSum;
        
        for(int i=0; i<nums.length; i++){
            rightSum = rightSum - nums[i];
            
            if(leftSum == rightSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
