// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }
class subTreeInfo{
    
    int size;
    int maxVal;
    int minVal;
    boolean isBST;
    
    subTreeInfo(int size, int maxVal, int minVal, boolean isBST){
        this.size = size;
        this.maxVal = maxVal;
        this.minVal = minVal;
        this.isBST =  isBST;
    }
    subTreeInfo(int size, boolean isBST){
        this.size = size;
        this.isBST = isBST;
    }
}


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
     int largestBst(Node root)
    {
        return findLargestBST(root).size;
        
    }
    
    private  subTreeInfo findLargestBST(Node root){
        if(root == null)
          return new subTreeInfo(0, 0, 10000000, true);
          
        if(root.left == null && root.right == null)
          return new subTreeInfo(1, root.data, root.data, true);
          
        subTreeInfo leftAns = findLargestBST(root.left);
        subTreeInfo rightAns = findLargestBST(root.right);
        
        if(leftAns.isBST && rightAns.isBST && leftAns.maxVal < root.data && root.data < rightAns.minVal){
            int maximumVal = Math.max(Math.max(leftAns.maxVal, rightAns.maxVal), root.data);
            int minimumVal = Math.min(Math.min(leftAns.minVal, rightAns.minVal), root.data);
            return new subTreeInfo(leftAns.size + rightAns.size + 1, maximumVal, minimumVal, true);
        }
        else{
            return new subTreeInfo(Math.max(leftAns.size, rightAns.size), 0, 0, false);
        }
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
