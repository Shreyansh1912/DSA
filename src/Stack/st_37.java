public String infixToPostFix(String infix){   //TC: O(N), SC: O(N)
        Stack<String> stack = new Stack<>();
        String result = "";

        Map<Character, Integer> priorityMap = new HashMap<>();
        priorityMap.put('(', 6);
        priorityMap.put('^', 5);
        priorityMap.put('/', 4);
        priorityMap.put('*', 4);
        priorityMap.put('+', 3);
        priorityMap.put('-', 3);

        for(Character currentChar: infix.toCharArray()){
            if(currentChar == '('){
                stack.push(currentChar + "");
            }
            else if(currentChar == ')'){
                while(!stack.isEmpty() && stack.peek() != "("){
                    result += stack.pop();
                }
               stack.pop();
            }
            else if(isOperator(currentChar)){
                while(!stack.isEmpty() && priorityMap.get(currentChar) <= priorityMap.get(stack.peek())){
                    result += stack.pop();
                }
                stack.push(currentChar + "");
            }
            else{
                result += currentChar;
            }
        }
        while(!stack.isEmpty()){
           result += stack.pop();
        }
        return result;
}
private boolean isOperator(Character currentChar) {
        return currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/' || currentChar == '^';
    }
