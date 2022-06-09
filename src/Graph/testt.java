// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visited = new boolean[V];
        HashSet<Integer> recStack = new HashSet<>();
        
        for(int currentVertex = 0; currentVertex < V; currentVertex++){
            
            if(visited[currentVertex] == false)
              if(hasCycle(adj, currentVertex, visited, recStack))
                return true;
        }
        return false;
    }
    private boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int currentVertex, boolean[] visited, HashSet<Integer> recStack){
        visited[currentVertex] = true;
        recStack.add(currentVertex);
        
        for(int currentNeigh: adj.get(currentVertex)){
            
         if(visited[currentNeigh] == false){
            if(hasCycle(adj, currentNeigh, visited, recStack))
               return true;
         }
            
         else if(recStack.contains(currentNeigh))
               return true;
        }
        
        recStack.remove(currentVertex);
        return false;
    }
}
