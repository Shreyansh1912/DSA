//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        long[] temp= new long[arr.length];
        long ans=findmerging(arr,temp,0,arr.length-1);
        return ans;
   }
   public static long findmerging(long[] arr, long[] temp, int left, int right)
   {
       int mid=0;
       long cnt=0;
       
       if(right>left)
       {
           mid=(left+right)/2;
           cnt+=findmerging(arr,temp,left,mid);
           cnt+=findmerging(arr,temp,mid+1,right);
           cnt+=merge(arr,temp,left,mid+1,right);
       }
       return cnt;
   }
   public static long merge(long[] arr, long[] temp, int left, int mid, int right)
   {
       int i,j,k;
       long cnt=0;
       i=left;
       j=mid;
       k=left;
       
       while((i<=mid-1) && (j<=right))
       {
           if(arr[i]<=arr[j])
           {
               temp[k++]=arr[i++];
           }
           else
           {
                temp[k++]=arr[j++];
                cnt+=(mid-i);
           }
       }
       
       while(i<=mid-1)
       {
           temp[k++]=arr[i++];
       }
       
       while(j<=right)
       {
            temp[k++]=arr[j++];
       }
        for(i=left;i<=right;i++)
        {
          arr[i]=temp[i];
        }
       
       return cnt;
   }
}
