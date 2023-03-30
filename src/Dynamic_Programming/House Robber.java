class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return maxMoney(nums, 0, memo);
    }
    private int maxMoney(int[] nums, int currentHouse, HashMap<Integer, Integer> memo){
        if(currentHouse >= nums.length) return 0;
        
        int currentKey = currentHouse;

        if(memo.containsKey(currentKey))
           return memo.get(currentKey);

        int rob = nums[currentHouse] + maxMoney(nums, currentHouse+2, memo);
        int noRob = maxMoney(nums, currentHouse+1, memo);
        
        memo.put(currentKey, Math.max(rob, noRob));
        return memo.get(currentKey);
    }
}
