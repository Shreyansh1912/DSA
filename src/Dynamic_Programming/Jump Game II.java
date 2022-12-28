class Solution {
    public int jump(int[] nums) {
        return minJumps(nums, 0, new HashMap<>());
    }
    private int minJumps(int[] nums, int currentIndex, HashMap<Integer, Integer> memo){
        if(currentIndex >= nums.length-1)
          return 0;

        if(nums[currentIndex] == 0)
          return 100001;
        
        int currentKey = currentIndex;

        if(memo.containsKey(currentKey))
          return memo.get(currentKey);

        int currentJumps = nums[currentIndex];
        int ans=100001;

         for(int i = 1; i <= currentJumps; i++){
             int tempAns = 1 + minJumps(nums, currentIndex + i, memo);
             ans = Math.min(ans, tempAns);
         }   
        memo.put(currentKey, ans);
        return ans;
    }
}
