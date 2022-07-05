// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

 class Solution{
    long minTime(int[] arr,int n,int k){
        long start = 0;
        long end = findSum(arr);
        
        long answer = -1;
        
        while(start <= end){
            long mid = start + (end - start)/2;
            
            if(isPossible(arr, n, k, mid)){
               answer = mid;
               end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return answer;
    }
    
    private long findSum(int[] nums){
        long total = 0;
        for(int x: nums)
            total += x;
            
        return total;
    
    }
    private boolean isPossible(int[] pages, int booksCount, int studentCount, long bound){
        long currentSum = 0;
        int currentStudentCount = 1;
        
        for(int currentBookPages: pages){
            
            if(currentBookPages > bound)
              return false;
              
            if(currentSum + currentBookPages <= bound)  
              currentSum += currentBookPages;
              
            else{
                currentStudentCount += 1;
                currentSum = currentBookPages;
                
                if(currentStudentCount > studentCount)
                  return false;
            }  
        }
        return true;
    }
}


