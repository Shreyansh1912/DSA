// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Pair{
   int node;
   int parent;
   Pair(int node , int parent)
   {
       this.node = node;
       this.parent = parent;
   }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       // Code here
       boolean []vis = new boolean[V];
       for(int i = 0 ; i < V ; i++)
       {
           // if(!vis[i] && dfs(i,-1,adj,vis)) return true;
           if(!vis[i] && bfs(i,-1,adj,vis)) return true;
       }
       return false;
   }
public boolean bfs(int src ,int parent ,  ArrayList<ArrayList<Integer>> adj ,boolean []vis)
   {
   	
       Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(src,parent));
       while(q.size()>0)
       {
           Pair top = q.remove();
           int node = top.node;
           int p = top.parent;
           
           vis[node] = true;
           
           for(int i : adj.get(node))
           {
               if(vis[i] == false)
               {
                   q.add(new Pair(i,node));
               }
               else if(i!=p)
               {
                   return true;
               }
           }
       }
       return false;
   }
}
   
