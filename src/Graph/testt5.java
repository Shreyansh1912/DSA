class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      ArrayList<ArrayList<Integer>> graph = constructGraph(numCourses, prerequisites);
        
        int[] inDegree = new int[numCourses];
        
        for(int currentCourse = 0; currentCourse < numCourses; currentCourse++){
            for(int currentNeigh : graph.get(currentCourse)){
                inDegree[currentNeigh] += 1;
                
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> order = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        boolean[] visited = new boolean[numCourses];
        
        while(!queue.isEmpty()){
            int currentCourse = queue.remove();
            
            if(visited[currentCourse])
                continue;
            
            visited[currentCourse] = true;
            order.add(currentCourse);
            
            for(int currentNeigh: graph.get(currentCourse)){
                inDegree[currentNeigh] -= 1;
                
                if(inDegree[currentNeigh] == 0)
                    queue.add(currentNeigh);
            }
        }
         return order.size() == numCourses;
    }
    private  ArrayList<ArrayList<Integer>> constructGraph(int n, int[][] edges){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<Integer>());
        for(int[] currentEdges: edges){
            int a = currentEdges[0];
            int b = currentEdges[1];
            graph.get(b).add(a);
        }
        return graph;
        
    }
}
