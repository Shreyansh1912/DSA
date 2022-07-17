//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends

class TrieNode{
    TrieNode children[];
    boolean isEndOfWord;
    
    TrieNode(){
        children = new TrieNode[26];
        for(int i=0; i<26; i++)
            children[i] = null;
        
        isEndOfWord = false;
    }
    void insert(TrieNode root, String str){
        TrieNode curr = root;
        for(int i=0; i<str.length(); i++){ 
          char c = str.charAt(i);
          int index = c - 'a';
            if(curr.children[index] == null)
            {
                curr.children[index] = new TrieNode();
            }
            curr=curr.children[index];
        }
        curr.isEndOfWord = true;
    }
    boolean search(TrieNode root, String str){
        TrieNode curr = root;
        for(int i=0; i<str.length(); i++){ 
          char c = str.charAt(i);
          int index = c - 'a';
            if(curr.children[index] == null)
            {
                return false;
            }
            curr=curr.children[index];
        }
        if(curr != null && (curr.isEndOfWord == true))
             return true;
        return false;   
    }
    
}
//User function Template for Java

class Solution
{
    public static boolean wordBreakUtil(String A, TrieNode root){
        if(A.length() == 0)
          return true;
        
        for(int i=1; i<=A.length(); i++)
        {
            if(root.search(root, A.substring(0, i)) && wordBreakUtil(A.substring(i, A.length()), root))
            return true;
        }
        return false;
    }
    public static int wordBreak(String A, ArrayList<String> B )
    {
        TrieNode root = new TrieNode();
        for(int i=0; i<B.size(); i++)
            root.insert(root, B.get(i));
            
        boolean res = wordBreakUtil(A, root);
        if(res)
            return 1;
        else
            return 0;
        
    }
}
