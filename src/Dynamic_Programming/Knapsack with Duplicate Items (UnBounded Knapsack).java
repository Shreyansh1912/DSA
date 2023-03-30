//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int knapSack(int N, int capacity, int val[], int wt[])
    {
        int[][] dp = new int[N][capacity+1];
        
        for(int i=0; i<N; i++)
          for(int j=0; j<capacity+1; j++)
             dp[i][j] = -1;
             
        return maxProfit(wt, val, 0, capacity, N, new HashMap<String, Integer>(), dp);
    }
    
    private int maxProfit(int[] weights, int[] profit, int currentIndex, int capacity, int N, HashMap<String, Integer> memo, int[][] dp){
        
        if(capacity == 0) return 0;
        
        if(currentIndex == N) return 0;
        
        int currentIndexWeight = weights[currentIndex];
        int currentIndexProfit = profit[currentIndex];
        
        if(dp[currentIndex][capacity] != -1)
           return dp[currentIndex][capacity];
        
        int consider=0;
        
        if(currentIndexWeight <= capacity)
          consider = currentIndexProfit + maxProfit(weights, profit, currentIndex, capacity-currentIndexWeight, N, memo, dp);
          
        int notConsider = maxProfit(weights, profit, currentIndex+1, capacity, N, memo, dp);
        
        dp[currentIndex][capacity] = Math.max(consider, notConsider);
        return dp[currentIndex][capacity];
    }
}
