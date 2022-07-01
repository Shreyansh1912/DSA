package Recursion_And_BackTracking;

import java.util.ArrayList;
import java.util.List;

class RB_01 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), answer);
        return answer;
    }
    //TC: (2)*n SC:(2)*n
    private void generateSubsets(int[] nums, int currentIndex, ArrayList<Integer> currentSubset, List<List<Integer>> answer){

        if(currentIndex >= nums.length){
            answer.add(new ArrayList<>(currentSubset));
            return;
        }

        currentSubset.add(nums[currentIndex]);

        generateSubsets(nums, currentIndex+1, currentSubset, answer);
        currentSubset.remove(currentSubset.size()-1);
        generateSubsets(nums, currentIndex+1, currentSubset, answer);
        return;
    }
}
