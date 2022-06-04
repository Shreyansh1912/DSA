class Solution {
    public int findCircleNum(int[][] graph) {
        int n = graph.length;
        int answer=0;
        
        boolean[] visited = new boolean[n];
        
        for(int currentCity = 0; currentCity < n; currentCity++){
            if(visited[currentCity] == false){
                dfs(graph, currentCity, n, visited);
                answer += 1;
            }
        }
        return answer;
    }
    private void dfs(int[][] graph, int currentCity, int n, boolean[] visited){
        
        if(visited[currentCity])
            return;
        
        visited[currentCity] = true;
        int[] neighbours = graph[currentCity];
        
        for(int i=0; i<n; i++){
            if(neighbours[i] == 1)
                dfs(graph, i, n, visited);
        }
        return;
    }
}
