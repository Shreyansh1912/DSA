class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return totalWays(nums, 0, target, new HashMap<String, Integer>());
    }
    private int totalWays(int nums[], int currentIndex, int targetSum, HashMap<String, Integer> memo){

        if(currentIndex == nums.length && targetSum == 0) return 1;

        if(currentIndex == nums.length && targetSum != 0) return 0;
        
        String currentKey = Integer.toString(currentIndex) + "_" +Integer.toString(targetSum);

        if(memo.containsKey(currentKey))
            return memo.get(currentKey);

        int consider = totalWays(nums, currentIndex + 1, targetSum - nums[currentIndex], memo);
        int notConsider = totalWays(nums, currentIndex + 1, targetSum + nums[currentIndex], memo);
         
         memo.put(currentKey, consider + notConsider);
         return memo.get(currentKey);
    }
}
