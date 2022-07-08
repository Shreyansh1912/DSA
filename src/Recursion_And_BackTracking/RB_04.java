//class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> answer = new ArrayList<>();
//         List<Integer> ds = new ArrayList<>();
//         boolean[] freq = new boolean[nums.length];
//         recPermute(nums, ds, freq, answer);
//         return answer;
//     }   
//     //Time Complexity:  N! x N , Space Complexity:  O(N) + O(N) = O(2N) ~ O(N)
//  private void recPermute(int[] nums,  List<Integer> ds, boolean[] freq, List<List<Integer>> answer){
//         if(ds.size() == nums.length){
//             answer.add(new ArrayList<>(ds));
//             return;
//         }
//         for(int i=0; i<nums.length; i++){
//             if(!freq[i]){
//             ds.add(nums[i]);
//             freq[i] = true;
//             recPermute(nums, ds, freq, answer);
//             ds.remove(ds.size()-1);
//             freq[i] = false;
//           }
//         }
//     }
    
// }
    //Time Complexity: O(N! X N) 
    //Space Complexity: O(1)

     class Solution{
     private void recurPermute(int index, int[] nums, List < List < Integer >> ans) {
        if (index == nums.length) {
            // copy the ds to ans
            List < Integer > ds = new ArrayList < > ();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList < > (ds));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);
        }
    }
     private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public List < List < Integer >> permute(int[] nums) {
        List < List < Integer >> ans = new ArrayList < > ();
        recurPermute(0, nums, ans);
        return ans;
    }
}

    
