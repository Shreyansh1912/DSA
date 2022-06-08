// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends

class Solution
{
    //Function to find a Mother Vertex in the Graph.
    Stack<Integer> st = new Stack<>();
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean flag=false;
        int count =0;
        for(int i =0;i<V;i++){
             boolean [] visited=new boolean[V];
             DFS(adj,visited,i);
             
             for(int j=0;j<visited.length;j++){
                 if(visited[j]==true){
                     count++;
                 }
             }
             
             
             if(count==V){
                 return i;
             }

             count=0;
        }
    
      return -1;
    }
    
    public void DFS(ArrayList<ArrayList<Integer>>adj,boolean [] visited,int src){
        visited[src]=true;
        
        for(int a:adj.get(src)){
            if(visited[a]==false){
               DFS(adj,visited,a); 
            }
            
        }
    }
}
