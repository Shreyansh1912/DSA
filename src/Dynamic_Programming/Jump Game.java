class Solution {
    public boolean canJump(int[] nums) {
        return isPossible(nums, 0, new HashMap<Integer, Boolean>());
    }
    public boolean isPossible(int[] nums, int currentIndex, HashMap<Integer,Boolean> memo){
        if(currentIndex >= nums.length - 1)
            return true;
        
        int currentJump = nums[currentIndex];
        
        if(currentJump >= nums.length - currentIndex)
            return true;
        
        int currentKey = currentIndex;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        boolean ans = false;
        
        for(int i=1; i<=currentJump; i++){
            boolean tempAns = isPossible(nums, currentIndex + i, memo);
            ans = ans || tempAns;
        }
        
        memo.put(currentKey,ans);
           return ans;
    }
}
