import java.io.*;
import java.util.*;

public class Main {
    
    static class Pair{
        Stack<Integer> st;
        char sign;
        Pair(Stack<Integer> s, char si){
            st = s;
            sign = si;
        }
    }
    public static void cal(Stack<Integer> st, int val, char sign){
                if(sign == '+'){
                    st.push(val);
                } else if(sign == '-'){
                    st.push(-val);
                } else if(sign == '*'){
                    int a = st.pop();
                    int ans = a * val;
                    st.push(ans);
                } else if(sign == '/'){
                    int a = st.pop();
                    int ans = a / val;
                    st.push(ans);
                }
    }
    public static  int calculate(String s) {
         Stack<Integer> st = new Stack<>();
         Stack<Pair>  stP = new Stack<>();
        char sign = '+';
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch))
            {
                int val=0;
                while(i < s.length() && Character.isDigit(s.charAt(i)))
                {
                  val = val * 10 +  (s.charAt(i) - '0');
                  i++;
                } 
                i--;
                cal(st, val, sign);
                
            } else if(ch == '('){
                stP.push(new Pair(st, sign));
                sign = '+';
                st= new Stack<>();
            } else if(ch == ')'){
                int val = 0;
                while(st.size() > 0){
                    val += st.pop();
                }
                Pair p = stP.pop();
                st = p.st;
                sign = p.sign;
                
                cal(st, val, sign);
            }else if(ch != ' '){
                sign = ch;
            }
        }
        int sum = 0;
        while(st.size() > 0){
            sum += st.pop();
        }
            
       return sum;
    }

  
 public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int result = calculate(read.readLine());
    System.out.println(result);

  }
}
