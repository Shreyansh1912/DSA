//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Minimum
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
              GfG gfg = new GfG();
            int Q = sc.nextInt();
            
            
            int st[] = gfg.constructST(arr, n);
            int l,r;
            for(int i = 0; i < Q; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                l = Math.min(a,b);
                r = Math.max(a,b);
                
                System.out.print(gfg.RMQ(st, n, l, r) + " ");
                
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/* The functions which 
builds the segment tree */
class GfG
{
    int segmentTree[];
    int arr[];
    int n;
    
    final int MAXIUMUM_VALUE = Integer.MAX_VALUE;
    
    public int[] constructST(int arr[], int n)
    {
        this.arr = arr;
        this.n = n;
        
        segmentTree = new int[4*n];
        Arrays.fill(segmentTree, MAXIUMUM_VALUE);
        constructSegmentTree(0, n-1, 0);
        
        return segmentTree;
    }
    
    
    /* The functions returns the
      min element in the range
      from l and r */
    public int RMQ(int segmentTreet[], int n, int l, int r)
    {
       return getMaxQuery(0, n-1, l, r, 0);
    }
    private int getMaxQuery(int start, int end, int left, int right, int currentIndex){
        if(end < left || start > right)
            return Integer.MAX_VALUE;

        if(start >= left && right >= end)
            return segmentTree[currentIndex];

        int mid = start + (end - start) / 2;

        int leftCall =  getMaxQuery(start, mid,  left, right, 2*currentIndex + 1);
        int rightCall = getMaxQuery(mid+1, end, left, right,  2*currentIndex + 2);

        return Math.min(leftCall , rightCall);
    }
     private void constructSegmentTree(int start, int end, int currentIndex){
        if(start > end)
            return;

        if(start == end){
            segmentTree[currentIndex] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;

        constructSegmentTree(start, mid, 2*currentIndex+1);
        constructSegmentTree(mid+1, end, 2*currentIndex+2);

        segmentTree[currentIndex] = Math.min(segmentTree[2*currentIndex+1] , segmentTree[2*currentIndex+2]);

        return;
    }
    
    
}
