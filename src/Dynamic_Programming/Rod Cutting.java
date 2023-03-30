//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int l) {
        return maxProfit(price, 0, l, new HashMap<String, Integer>());
    }
    private int maxProfit(int[] price, int currentIndex, int l, HashMap<String, Integer> memo){
        
        if(l == 0) return 0;
        
        if(currentIndex >= price.length) return 0;
       
        String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(l);
        
         if(memo.containsKey(currentKey))
          return memo.get(currentKey);
          
        int currentPieceLength = currentIndex + 1;
        
        int consider = 0;
        if(currentPieceLength <= l)
          consider = price[currentIndex] + maxProfit(price, currentIndex, l-currentPieceLength, memo);
        
        int notConsider = maxProfit(price, currentIndex + 1, l, memo);
        
        memo.put(currentKey, Math.max(consider, notConsider));
        return memo.get(currentKey);
     
    }
}
