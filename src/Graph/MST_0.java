import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

// private int find(int[] parents, int a){
    
//     if(parents[a] == a)
//         return a;
        
//     return find(parents, parents[a]);
// }

// private void union(int[] parents, int a, int b){
    
//     int rootA = find(parents, a);
//     int rootB = find(parents, b);
    
//     parents[rootA] = rootB;
//     return;
// }



class Edge implements Comparable<Edge>{
    
    int src;
    int dest;
    int weight;
    
    Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    public int compareTo(Edge others){
        return this.weight - others.weight;
    }
}

class Solution
{
    private int findByPathCompression(int[] parents, int a){
    
        if(parents[a] == a)
            return a;
        else
            parents[a] = findByPathCompression(parents, parents[a]);
            
        return parents[a];
    
    }

    private void unionByRank(int[] parents, int[] ranks, int a, int b){
        int rootA = findByPathCompression(parents, a);
        int rootB = findByPathCompression(parents, b);
        
        if(ranks[rootA] > ranks[rootB])
            parents[rootB] = rootA;
            
        else if(ranks[rootB] > ranks[rootA])
            parents[rootA] = rootB;
            
        else{
            parents[rootA] = rootB;
            ranks[rootB] += 1;
        }
        
        return;
    }
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        int minCost = 0;
        List<Edge> edges = getEdgesArray(V, adj);
        Collections.sort(edges);
        
        int i = 0;
        int edgesPicked = 0;
        
        int[] parents = new int[1001];
        int[] ranks = new int[1001];
        
        for(int j = 0; j < V; j++)
            parents[j] = j;
        
        while(edgesPicked < V-1 && i < edges.size()){
            Edge currentEdge = edges.get(i);
            int src = currentEdge.src;
            int dest= currentEdge.dest;
            int weight = currentEdge.weight;
            
            int srcRoot = findByPathCompression(parents, src);
            int destRoot = findByPathCompression(parents, dest);
            
            if(srcRoot != destRoot){
                minCost += weight;
                edgesPicked += 1;
                unionByRank(parents, ranks, src, dest);
            }
            
            i+=1;
        }
        
        return minCost;
    }
    
    private List<Edge> getEdgesArray(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        List<Edge> edges = new ArrayList<>();
        
        for(int currentVertex = 0; currentVertex < V; currentVertex++){
            ArrayList<ArrayList<Integer>> neighbours = adj.get(currentVertex);
            
            for(ArrayList<Integer> neighbour: neighbours){
                int dest = neighbour.get(0);
                int weight = neighbour.get(1);
                edges.add(new Edge(currentVertex, dest, weight));
            }
        }
        
        return edges;
    }
}
