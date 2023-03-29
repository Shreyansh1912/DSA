public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int currentVal: A){
          while(!st.isEmpty() && st.peek() >= currentVal){
            st.pop();
          }
        al.add(st.isEmpty() ? -1 : st.peek());
        st.push(currentVal);
        }
        return al;
    }
   
}
