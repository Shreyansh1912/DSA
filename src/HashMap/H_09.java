import java.util.*;

public class H_09 {

    public static int solution(int[] arr) {
        int answer = 0;
        HashMap<String, Integer> memo = new HashMap<>();
        int z0 = 0;
        int z1 = 0;
        int z2 = 0;
        
        String expr = (z1-z0) + "-" + (z2-z1);
        memo.put(expr, -1);
        
        for(int i=0; i < arr.length;i++){
            if(arr[i] == 0)
              z0 += 1;
            else if(arr[i] == 1)
              z1 += 1;
            else
              z2 += 1;
              
        expr = (z1-z0) + "-" + (z2-z1);
        
         if(memo.containsKey(expr))
           {
            answer = Math.max(answer, i - memo.get(expr));
            }
          else{
              memo.put(expr, i);
              }
        }
        return answer;

       
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
