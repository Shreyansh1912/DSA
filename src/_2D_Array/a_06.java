//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
           for(int j=0;j<m;j++){
           for(int i=0;i<n;i++){
               if(arr[i][j]==1)         //Tc:O(N+M)
               return i;
           }
       }
       return -1;
   }
}
   //     Tc:0(N*LogM)
//         int omax = 0;
//         int r = 0;
        
//         for(int i=0; i<arr.length; i++){
//             int coir = binarySearch(arr, i);  //count no. of one's in ith row 
            
//             if(coir > omax){
//                 coir = omax;
//                 r = i;
//             }
//         }
//         return r;
//     }
//     public  int binarySearch(int[][] arr, int r){
//         int low = 0;
//         int high = arr[0].length-1;
//         int fi1 = arr[0].length;
        
//         while(low <= high){
//             int mid = (low+high)/2;
//             if(arr[r][mid] == 1){
//                 fi1 = mid;
//                 high = mid - 1;
//             } else{
//                 low = mid + 1;
//             }
//         }
//         int count = arr[0].length - fi1;
//         return count;
//     }
// }
