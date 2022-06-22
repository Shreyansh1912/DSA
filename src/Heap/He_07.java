// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
         ArrayList<Integer> list = new ArrayList<>();
        
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        
        for(int i=0; i<arr.length; i++){
            pq.add(new Triplet(arr[i][0], i, 0));
        }
        
        Triplet cur;
        while(!pq.isEmpty()){
            cur = pq.poll();
            list.add(cur.val);
            
            if(cur.vPos < arr[cur.aPos].length-1){
                pq.add(new Triplet(arr[cur.aPos][cur.vPos+1], cur.aPos, cur.vPos+1));
            }
        }
        
        return list;
    }
    
    private static class Triplet implements Comparable<Triplet>{
        int val, aPos, vPos;
        Triplet(int v, int ap, int vp){
            val = v;
            aPos = ap;
            vPos = vp;
        }
        
        
        public int compareTo(Triplet o){
            if(this.val <= o.val){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
