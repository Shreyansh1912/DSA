class Pair{
    int vertex;
    int color;
    Pair(int vertex, int color){
        this.vertex = vertex;
        this.color = color;
    }
}


class Solution {
    public boolean isBipartite(int[][] graph) {
        int n =graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        for(int currentVertex = 0; currentVertex < n; currentVertex++){
            
            if(colors[currentVertex] != -1)
                continue;
            
            if(!hasEvenCycleBFS(graph, currentVertex, 0, colors))
                return false;
            
        }
        return true;
    }
    private boolean hasEvenCycleBFS(int[][] graph, int vertex, int currentColor, int[] colors){
         Queue<Pair> queue = new LinkedList<>();
         queue.add(new Pair(vertex, 0));
        
        while(!queue.isEmpty()){
            Pair currentPair = queue.remove();
            int  currentVertex = currentPair.vertex;
            int  color = currentPair.color;
            
            if(colors[currentVertex] != -1){
                if(colors[currentVertex] != color)
                    return false;
            } else{
                colors[currentVertex] = color;
                
                for(int currentNeigh: graph[currentVertex]){
                    queue.add(new Pair(currentNeigh, 1-color));
                }
            }
        }
        return true;
    }
}
