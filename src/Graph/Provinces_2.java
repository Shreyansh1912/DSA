class Solution {
    public int findCircleNum(int[][] graph) {
        int n = graph.length;
        int answer=0;
        
        boolean[] visited = new boolean[n];
        
        for(int currentCity = 0; currentCity < n; currentCity++){
            if(visited[currentCity] == false){
                bfs(graph, currentCity, n, visited);
                answer += 1;
            }
        }
        return answer;
    }
    private void bfs(int[][] graph, int currentCity, int n, boolean[] visited){
         Queue<Integer> queue = new LinkedList<>();
         queue.add(currentCity);

        while(!queue.isEmpty()){
            int currentVertex = queue.remove();
             if(visited[currentVertex])
                continue;

             visited[currentVertex] = true;
             int[] neighbours = graph[currentVertex];
        
            for(int i=0; i<n; i++){
               if(neighbours[i] == 1)
                queue.add(i);
            }
        }
        
    }
}
