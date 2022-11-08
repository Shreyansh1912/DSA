class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> curr = new ArrayList<>();
        
        curr.add(0);
        dfs(0, graph, curr, answer, graph.length-1);
        return answer;
    }
    
    private void dfs(int src, int[][] graph, List<Integer> curr, List<List<Integer>> answer, int dest){
        if(src == dest){
            answer.add(new ArrayList(curr));
            return;
        }
        for(int i:graph[src]){
            curr.add(i);
            dfs(i, graph, curr, answer, dest);
            curr.remove(curr.size()-1);
        }
    }
}
