class Solution {
    public String removeDuplicates(String s) {
    
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            if(!st.isEmpty() && st.peek() == s.charAt(i)){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
