class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            
            if(s.charAt(i) == ')'){
                Queue<Character> queue = new LinkedList<>();
                
                while(st.peek() != '('){
                    queue.add(st.pop());
                }
                st.pop();
                while(queue.size() > 0){
                    st.push(queue.remove());
                }
            } else{
                st.push(s.charAt(i));
            }
        }
        
        char[] ans = new char[st.size()];
        int i = ans.length-1;
        while(i >= 0){
         ans[i] = st.pop();
         i--;
         }
    return new String(ans);
    }
}
