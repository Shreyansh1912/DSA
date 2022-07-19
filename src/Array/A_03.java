//{ Driver Code Starts
import java.util.*;
class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(a, b, n));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution {
    public int findExtra(int a[], int b[], int n) {
        // add code here.
        int slow = 0;
        int fast = a.length-1;
        int res = 0;
        
        while(slow <= fast){
            int mid = slow + (fast - slow) / 2;
            if(mid < b.length && a[mid]==b[mid])
           {
               slow=mid+1;
           }
           else
           {
               res=mid;
               fast=mid-1;
           }
       }
       return res;
    }
}
