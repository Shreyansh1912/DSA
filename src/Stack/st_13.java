import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    //algo-->
    //1- nsl, nsr
    //2-width-->r-l-1
    //3. max area
    
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
    System.out.println(maxArea);
    
 }
}
