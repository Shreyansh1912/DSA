class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        findAllCombs(0, 0, "", n, answer);
        return answer;
    }
    //TC: O(expo.) , SC: O(Catalan No.)
    private void findAllCombs(int openCount, int closeCount, String expression, int n,  List<String> answer){
        
        if(openCount == closeCount && openCount == n){
            answer.add(expression);
        return;
        }
        if(openCount < n)
            findAllCombs(openCount + 1, closeCount, expression + "(", n, answer);
        
        if(openCount > closeCount)
            findAllCombs(openCount, closeCount + 1, expression + ")", n, answer);
        
        return;
    }
}
