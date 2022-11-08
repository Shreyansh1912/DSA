//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    boolean fact(int mid, int n){
        int prod = 5, c = 0;
        while(prod <= mid){
            c += (mid/prod);
            prod = prod * 5;
            
        }
        return c >= n;
        
    }
    int findNum(int n)
    {
        if(n == 1) return 5;
        
        int low=0, high=5*n;
        
        while(low < high){
            int mid = low + (high - low)/2;
            
            if(fact(mid, n)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}
