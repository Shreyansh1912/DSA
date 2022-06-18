import java.io.*;
import java.util.*;
// Algor---> 
       //1. Transpose --> to find transpose move either upper triangle or                move in lower triangle
       // 2. reverse row

public class Main {

    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       
       int n = sc.nextInt();
       int[][] arr = new int[n][n];
       
       for(int i=0; i<arr.length; i++){
           for(int j=0; j<arr[0].length; j++){
               arr[i][j] = sc.nextInt();
           }
       }
       //Transpose --> movie in either upper triangle or lower triangle
       for(int i=0; i<arr.length; i++){
           for(int j=i; j<arr[0].length; j++){ //-->upper triangle 
               int temp = arr[i][j];
               arr[i][j] = arr[j][i];
               arr[j][i] = temp;
           }
       }
      // reverse each row 
       for(int i=0; i<arr.length; i++){
           int li=0;
           int ri=arr[i].length-1;
           
           while(li < ri){
               int temp=arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;
                li++;
                ri--;
            }
       }
       display(arr);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
