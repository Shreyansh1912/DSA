class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        generateCombinations(candidates, 0, target, new ArrayList<>(), answer);
        return answer;
    }
    //TC: (2)*n SC:(2)*n
    private void generateCombinations(int[] candidates, int currentIndex, int target, ArrayList<Integer> current, List<List<Integer>> answer){

        if(target == 0){
            answer.add(new ArrayList<>(current));
            return;
        }
        if(currentIndex >= candidates.length){
            return;
        }
         
        if(candidates[currentIndex] <= target){
           current.add(candidates[currentIndex]);
          generateCombinations(candidates , currentIndex, target - candidates[currentIndex], current, answer);
          current.remove(current.size()-1);
        }
        generateCombinations(candidates , currentIndex+1, target, current, answer);
        return;
    }
}
