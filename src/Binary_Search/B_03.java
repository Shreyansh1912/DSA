class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length < 1)
            return new int[]{-1,-1};
        
        int[] answer = {-1, -1};
        
        answer[0] = findFirstPosition(nums, target);
        answer[1] = findLastPosition(nums, target);
        
        return answer;
        
    }
    private int  findFirstPosition(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        
        int startPositionIndex = -1;
        
        while(start <= end){
            
        int mid = start + (end - start)/2;
            
        if(nums[mid] == target){
             startPositionIndex = mid;
             end = mid - 1;
        } else if(nums[mid] > target){
            end = mid - 1;
        } else
            start = mid + 1;
        }
        return startPositionIndex;
    }
     private int  findLastPosition(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        
        int LastPositionIndex = -1;
        
        while(start <= end){
            
        int mid = start + (end - start)/2;
            
        if(nums[mid] == target){
             LastPositionIndex = mid;
             start = mid + 1;
        } else if(nums[mid] > target){
            end = mid - 1;
        } else
            start = mid + 1;
        }
        return LastPositionIndex;
    }
}
