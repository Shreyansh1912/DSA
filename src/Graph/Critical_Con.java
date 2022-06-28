class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
         List<List<Integer>> graph = constructGraph(n, connections);
         return findCriticalEdge(n, graph);
    }
    
    private  List<List<Integer>> findCriticalEdge(int n, List<List<Integer>> graph){
        int[] disTime = new int[n];
        int[] lowTime = new int[n];
        int[] time = {0};
        
        Arrays.fill(disTime, -1);
        Arrays.fill(lowTime, -1);
        
        List<List<Integer>> answer = new ArrayList<>();
        tarjansAlgo(0, time, -1, graph, disTime, lowTime, answer);
        return answer;
    }
    
    private void tarjansAlgo(int currentVertex, int[] time, int currentParent,  List<List<Integer>> graph, int[] disTime,  int[] lowTime,  List<List<Integer>> answer){
        disTime[currentVertex] = time[0];
        lowTime[currentVertex] = time[0];
        time[0] += 1;
        
        for(int currentNeigh: graph.get(currentVertex)){
            
            if(currentNeigh == currentParent)
                continue;
            
            if(disTime[currentNeigh] != -1){
                lowTime[currentVertex] = Math.min(lowTime[currentVertex], disTime[currentNeigh]);
                continue;
            }
            
            tarjansAlgo(currentNeigh, time, currentVertex, graph, disTime, lowTime, answer);
            lowTime[currentVertex] = Math.min(lowTime[currentVertex], lowTime[currentNeigh]);
            
            if(disTime[currentVertex] < lowTime[currentNeigh])
                answer.add(Arrays.asList(currentVertex, currentNeigh));
        }
        return;
    }
    
    private  List<List<Integer>> constructGraph(int n, List<List<Integer>> edges){
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<Integer>());
            
        for(List<Integer> edge: edges){
            int a = edge.get(0);
            int b = edge.get(1);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }    
       return graph;
    }
}
