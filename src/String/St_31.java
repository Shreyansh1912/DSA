//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int addMinChar(String str){
		//code here
		int i=0;
		int j=str.length()-1, trim=j, res=0;
		
		while(i < j){
		    if(str.charAt(i) == str.charAt(j)){
		        i++;
		        j--;
		    }
		    else{
		        res++;
		        i = 0;
		        j = --trim;
		    }
		}
		return res;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends
