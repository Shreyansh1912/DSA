//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String S = sc.nextLine().trim();
            Solution ob = new Solution();
            if(ob.valid(S))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean valid(String s) 
    { 
        Stack<Character> st = new Stack<>();
        
        for(Character currentChar: s.toCharArray()){
            if(currentChar == '(' || currentChar == '[' || currentChar == '{'){
                st.push(currentChar);
            }
            else{
                if(st.isEmpty()) return false;
                
                if(currentChar == ')' && st.peek() != '(')
                    return false;
                if(currentChar == ']' && st.peek() != '[')
                    return false;
                if(currentChar == '}' && st.peek() != '{')
                    return false;  
                    
                st.pop();    
            }
        }
        return st.isEmpty();
    }
} 
