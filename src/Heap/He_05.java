// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}

// } Driver Code Ends
class Solution
{
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        if(maxHeap.isEmpty() || maxHeap.peek() >= x)
           maxHeap.add(x);
        else
           minHeap.add(x);
           
        balanceHeaps();   
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
        //Either both heaps have equal no. of elemets or
        //maxHeap will have one more element than minHeap
      if(maxHeap.size() > minHeap.size() + 1)
          minHeap.add(maxHeap.poll());
          
        else if(maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());   
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        if(maxHeap.size() == minHeap.size())
        //we have even no. of elements return average of middle of two elments
          return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        else
           return (double) maxHeap.peek();
    }
    
}
