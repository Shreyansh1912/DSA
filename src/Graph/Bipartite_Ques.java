class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //Using Bipartite Graph
        ArrayList<ArrayList<Integer>> graph = constructGraph(n, dislikes);
        int[] colors = new int[n+1]; //given 1 to n
        Arrays.fill(colors, -1);

        for(int currentVertex = 0; currentVertex <= n; currentVertex++){

            if(currentVertex == 0 || colors[currentVertex] != -1)
                continue;

            if(!hasEvenCycle(graph, currentVertex, 0, colors))
                return false;

        }
        return true;
    }
   //1.Construct Graph by given dislike array
    private  ArrayList<ArrayList<Integer>> constructGraph(int n, int[][] edges){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] currentEdges: edges){
            int a = currentEdges[0];
            int b = currentEdges[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return graph;
    }
    
     private boolean hasEvenCycle( ArrayList<ArrayList<Integer>> graph, int currentVertex, int currentColor, int[] colors){
         if(colors[currentVertex] != -1)
             return colors[currentVertex] == currentColor;

        colors[currentVertex] = currentColor;

        for(int currentNeigh: graph.get(currentVertex)){

            if(!hasEvenCycle(graph, currentNeigh, 1-currentColor, colors))
                return false;

        }
        return true;
    }
}
