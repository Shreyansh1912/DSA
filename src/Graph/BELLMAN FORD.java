// { Driver Code Starts
//Initial Template for Java

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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //1. Initialize costs array
       int[] costs = new int[n];
       //2.Fill with infinity
       for(int i = 0; i < n; i++)
           costs[i] = Integer.MAX_VALUE;
      //3. source
       costs[0] = 0; 
       //4. Relax every edge by V-1
       for(int i = 0; i < n-1; i++){
           for(int[] currentEdges: edges){
               int src = currentEdges[0];
               int dest = currentEdges[1];
               int w = currentEdges[2];
               
               if(costs[src] != Integer.MAX_VALUE)
                 costs[dest] = Math.min(costs[dest], costs[src] + w);
           }
       }
       //5 Relax every edge one more time becz if have negative cycle in graph then we take min value
       for(int[] currentEdges: edges){
            int src = currentEdges[0];
            int dest = currentEdges[1];
            int w = currentEdges[2];
               
          if(costs[src] != Integer.MAX_VALUE && costs[dest] > costs[src] + w)
                  return 1;
           
       }
       return 0;
    }
}
