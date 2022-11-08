//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            
            int arr[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            for(int i = 0; i < n; i++)
              arr[(int)i] = Integer.parseInt(st[(int)i]);
              
            
            System.out.println(new Solution().maxStep(arr, n));
        }
    }
    
    
}
    
    

// } Driver Code Ends



class Solution
{
    //Function to find maximum number of consecutive steps 
    //to gain an increase in altitude with each step.
    int maxStep(int A[], int N)
    {
       int c = 0;
       int ms=0;
       for(int i=0; i<A.length-1; i++){
           if(A[i] < A[i+1]){
             c++;
           } else{
               if(c > ms){
                 ms = c;
                }
                 c=0;
              }
       }
       if(c > ms){
        ms = c;
      }
       return ms;
       
    }
   
    
}
