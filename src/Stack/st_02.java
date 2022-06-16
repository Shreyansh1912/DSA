import java.io.*;
import java.util.*;

public class st_02{
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    
    Stack<Integer> opnds = new Stack<>();
    Stack<Character> optors = new Stack<>();
    
    for(int i = 0; i< exp.length(); i++){
        char ch = exp.charAt(i);
    
    if(ch == '(' ){
     optors.push(ch);
    }
     
    else if(ch == ')'){
       while(optors.peek() != '('){
         char optor = optors.pop(); 
         int v2 = opnds.pop();
         int v1 = opnds.pop();
         
         int opv = operations(v1, v2, optor);
         opnds.push(opv);
        }  
        optors.pop();
    }
         
    else if(Character.isDigit(ch)){
      opnds.push(ch -'0'); //char to int
    }
      
    else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
        // ch is waiting for higher priority operators to solve first
        while(optors.size() > 0 && optors.peek() != '(' && precedence(ch) <= precedence(optors.peek())){
         char optor = optors.pop(); 
         int v2 = opnds.pop();
         int v1 = opnds.pop();
         
         int opv = operations(v1, v2, optor);
         opnds.push(opv);
        }  
        // ch is pushing itself now
        optors.push(ch);
    }   
}
    while(optors.size() != 0){
         char optor = optors.pop(); 
         int v2 = opnds.pop();
         int v1 = opnds.pop();
         
         int opv = operations(v1, v2, optor);
         opnds.push(opv);
        } 
        System.out.println(opnds.peek());
        
}

    public static int precedence(char optor){
     if(optor == '+'){
      return 1;
     }
     else if(optor == '-'){
      return 1;
     }
     else if(optor == '*'){
      return 2;
     }
     else{
      return 2;
     }
    }
   public static int operations(int val1 , int val2, char optor){
    if(optor == '+'){
      return val1 + val2;
    }
      
    else if(optor == '-'){
      return val1 - val2;
    }
      
    else if(optor == '*'){
       return val1 * val2;
    }
    else{
       return val1 / val2;
    }
   }    
}
