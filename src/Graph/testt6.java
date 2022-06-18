//DFS Approach
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = constructGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        ArrayList<Integer> order = new ArrayList<>();
        
        for(int currentCourse = 0;  currentCourse < numCourses; currentCourse++){
            if(visited[currentCourse] == false)
                if(DFS(graph, currentCourse, visited, new HashSet<Integer>(), order))
                   return new int[0];
            
        }
        Collections.reverse(order);
        int[] answer = new int[numCourses];
        
        for(int i=0; i < numCourses; i++)
            answer[i] = order.get(i);
        
        return answer;
    }
     
    private boolean DFS(ArrayList<ArrayList<Integer>> graph, int currentCourse, boolean[] visited, HashSet<Integer> recStack, ArrayList<Integer> order){
        
        visited[currentCourse] = true;
        recStack.add(currentCourse);
        
        for(int currentNeigh: graph.get(currentCourse)){
            if(visited[currentNeigh] == false){
                if(DFS(graph, currentNeigh, visited, recStack, order))
                   return true;
            }
            else if(recStack.contains(currentNeigh))
                   return true;
        }
         recStack.remove(currentCourse);
         order.add(currentCourse);
         return false;
        
    }              
                   
     private  ArrayList<ArrayList<Integer>> constructGraph(int n, int[][] edges){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<Integer>());
         
        for(int[] currentEdges: edges){
            int a = currentEdges[0];
            int b = currentEdges[1];
            graph.get(b).add(a);   //graph.get(a).add(b); then we don't use to reverse
        }
        return graph;
        
    }
}
