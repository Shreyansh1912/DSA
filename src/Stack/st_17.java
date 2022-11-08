class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)  return 0;
        int maxArea = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dp[j] = matrix[i][j] == '1' ? dp[j]+1 : 0;
            }
    //treating dp[j] as histogram, solving max area problem there and updating the max area
            maxArea = Math.max(maxArea, findMaxAreaInHistogram(dp));
        }
        return maxArea;
    }
	//Largest Rectangle in Histogram code
    public int findMaxAreaInHistogram(int[] arr){
    int[] rb =  new int[arr.length];// nse  index on right
    Stack<Integer> st = new Stack<>();
    st.push(arr.length-1);
    rb[arr.length-1]=arr.length;

    // algo--> to find smaller element -->pop, answer, push
    for(int i = arr.length-2; i >= 0; i--){
        while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
            st.pop();
        }
        if(st.isEmpty()){
            rb[i]=arr.length;
        } else{
            rb[i]=st.peek();
        }
        st.push(i);
    }

    int[] lb =  new int[arr.length]; // nse index on left
    st = new Stack<>();
    st.push(0);
    lb[0] = -1;

    for(int i = 1; i < arr.length; i++){
        while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
            st.pop();
        }
        if(st.isEmpty()){
            lb[i] = -1;
        } else{
            lb[i] = st.peek();
        }
        st.push(i);
    }
   //area 
    int maxArea = 0;
    for(int i = 0; i < arr.length; i++){
        int width = rb[i] - lb[i] - 1;
        int area = arr[i] * width;
        if(area > maxArea){
            maxArea = area;
        }

    }
    return maxArea;

 }
}
