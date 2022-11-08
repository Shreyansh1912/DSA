class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate=0, missing=1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){             //TC: O(N+N)~O(2N)=O(N);
                                                      //SC: O(N)
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i], 1);
            } else{
                 duplicate=nums[i];
            }
        }
        for(int i=1; i<=nums.length; i++){
            if(!hm.containsKey(i)){
                missing=i;
                break;
            }
        }
        int[] arr = {duplicate, missing};
        return arr;
    }
}
