public String postfixToInfix(String postfix){   //TC: O(N), SC: O(N)
        Stack<String> stack = new Stack<>();

        for(int i=0; i<postfix.length(); i++){
            Character currentChar = postfix.charAt(i);

            if(isOperator(currentChar)){
               String firstVal = stack.pop();
               String secondVal = stack.pop();

               stack.push( "("+ secondVal +  currentChar+ firstVal + ")");
            } else{
                stack.push(currentChar + "");
            }
        }
        return stack.peek();
    }
private boolean isOperator(Character currentChar) {
        return currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/' || currentChar == '^';
    }
