package HashMap;
// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            H_01 g = new H_01();

            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans)
                System.out.print(val+" ");
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


class H_01
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> memo = new HashMap<>();
        int distinct =0;

        for(int i=0; i<k; i++){ // i <= k-1
            int currentVal = A[i];

            if(memo.containsKey(currentVal)){
                memo.put(currentVal, memo.get(currentVal)+1);
            }
            else{
                memo.put(currentVal ,1);
                distinct +=1 ;
            }
        }
        answer.add(distinct);
        int release=0;

        for(int acquire = k; acquire < n; acquire++){
            int discardElement = A[release];
            memo.put(discardElement, memo.get(discardElement)-1);
            release += 1;

            if(memo.get(discardElement) == 0){
                memo.remove(discardElement);
                distinct-=1;
            }

            int currentVal = A[acquire];
            if(memo.containsKey(currentVal)){
                memo.put(currentVal, memo.get(currentVal)+1);
            }

            else{
                memo.put(currentVal ,1);
                distinct +=1 ;
            }
            answer.add(distinct);
        }
        return answer;
    }

}


