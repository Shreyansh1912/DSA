// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] inDegree = new int[V];
        
        for(int currentVertex = 0; currentVertex < V; currentVertex++){
            for(int currentNeigh: adj.get(currentVertex))
             inDegree[currentNeigh] += 1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int currentVertex = 0; currentVertex < V; currentVertex++){
         if(inDegree[currentVertex] == 0){
             queue.add(currentVertex);
            }
        }
        boolean[] visited = new boolean[V];
        
        while(!queue.isEmpty()){
            int currentVertex = queue.remove();
            answer.add(currentVertex);
            
            visited[currentVertex] = true;
            
            for(int currentNeigh: adj.get(currentVertex)){
              inDegree[currentNeigh] -= 1;
              
              if(inDegree[currentNeigh] == 0)
                queue.add(currentNeigh);
            }
        }
        
        int[] order = new int[V]; //create a new array
        for(int i=0; i<V; i++)
            order[i] = answer.get(i);
            return order;
        
    }
}
