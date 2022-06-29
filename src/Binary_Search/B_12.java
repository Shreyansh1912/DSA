// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    boolean isFeasible(int[]A, int M, int res){
        int student = 1;
        int sum = 0;

        for(int i = 0; i < A.length; i++){
            sum += A[i];
            
            if(sum > res){
                student++;
                sum = A[i];
            } 
        }
        return student <= M ? true:false;
    }
    public int findPages(int[]A,int N,int M)
    {
        int maxOfArray = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < N; i++){
            maxOfArray = Math.max(A[i], maxOfArray);
            sum += A[i];
        }
        int start = maxOfArray;
        int end = sum;
        int res = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(isFeasible(A, M, mid)){
                res = mid;
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return res;
    }
};
