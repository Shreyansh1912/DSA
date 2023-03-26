public String prefixToPostFix(String prefix){   //TC: O(N), SC: O(N)
        Stack<String> stack = new Stack<>();

        for(int i=prefix.length()-1; i>=0; i--){
            Character currentChar = prefix.charAt(i);

            if(isOperator(currentChar)){
               String firstVal = stack.pop();
               String secondVal = stack.pop();

               stack.push(firstVal + secondVal + currentChar );
            } else{
                stack.push(currentChar + "");
            }
        }
        return stack.peek();
    }
private boolean isOperator(Character currentChar) {
        return currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/' || currentChar == '^';
    }
