//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
      
      int l = 0;
      int h = arr.length-1;
      
      if(arr[l] <= arr[h]){
          return 0;
      }
      
      while(l <= h){
          int mid = (l+h)/2;
          
          if(arr[mid] > arr[mid+1]){
            return mid+1;
          }
          else if(arr[mid] < arr[mid-1]){
            return mid;
          }
          else if(arr[l] <= arr[mid]){
            l = mid+1;
          }
          else if(arr[mid] <= arr[h]){
            h = mid-1;  
          }
      }
      return 0;
    }
}
