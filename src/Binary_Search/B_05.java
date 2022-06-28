class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        
        int firstPosition = findFirstPosition(nums, target);
        
        if(firstPosition == -1)
           return result;
           
        int LastPosition =  findLastPosition(nums, target);
        
        for(int i = firstPosition; i <= LastPosition; i++)
            result.add(i);
        
        return result;
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
