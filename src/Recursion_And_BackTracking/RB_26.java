// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthPosition(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution {
    static long nthPosition(long n){
        long c = 1;
        while(n != 1){
            c = 2 * c;
            n /= 2;
        }
        return c;
    }
}
