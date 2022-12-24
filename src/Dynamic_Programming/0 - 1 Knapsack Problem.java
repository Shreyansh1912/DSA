//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int capacity, int wt[], int val[], int n) 
    { 
        return maxProfit(wt, val, 0, capacity, n, new HashMap<String, Integer>());
    } 
    
    private int maxProfit(int[] weights, int[] profit, int currentItem, int capacity, int n, HashMap<String, Integer> memo){
        
        if(currentItem == n) return 0;
        
        int currentItemWeight = weights[currentItem];
        int currentItemProfit = profit[currentItem];
        
        
        String currentKey = Integer.toString(currentItem) + "-" + Integer.toString(capacity);
        
        if(memo.containsKey(currentKey))
          return memo.get(currentKey);
          
        int consider = 0;
        if(currentItemWeight <= capacity)
           consider = currentItemProfit + maxProfit(weights, profit, currentItem+1, capacity-currentItemWeight, n, memo);
           
        int notConsider = maxProfit(weights, profit, currentItem+1, capacity, n, memo);  
        
        memo.put(currentKey, Math.max(consider, notConsider));
        return memo.get(currentKey);
    }
}


