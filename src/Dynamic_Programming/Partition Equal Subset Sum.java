class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for(int num: nums)
            totalSum += num;

        if(totalSum % 2 != 0)
          return false;
        
        return isPossible(nums, 0, totalSum/2, new HashMap<String, Boolean>());

    }
    private boolean isPossible(int[] nums, int currentIndex, int targetSum, HashMap<String, Boolean> memo){
        if(targetSum == 0) return true;

        if(currentIndex >= nums.length) return false;

        String currentKey = Integer.toString(currentIndex) + "_" +Integer.toString(targetSum);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);

        boolean consider = false; 

        if(nums[currentIndex] <= targetSum)
          consider = isPossible(nums, currentIndex + 1, targetSum - nums[currentIndex], memo);
        
        if(consider){
            memo.put(currentKey, true);
            return true;
        }
        boolean notConsider = isPossible(nums, currentIndex + 1, targetSum, memo);  

        memo.put(currentKey, consider || notConsider);
         return memo.get(currentKey);
    }
}
