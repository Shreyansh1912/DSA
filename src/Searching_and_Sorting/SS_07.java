//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}

// } Driver Code Ends


class GfG
{
    int max_sum(int A[], int n)
    {
       int sum=0;
       int So = 0;
       
       for(int i=0; i<n; i++){
           sum += A[i];
           So += A[i] * i;
       }
       int max = So;
       int Si = So;
       
       for(int i=0; i<n-1; i++){
          int Sip1 = Si + sum - n*A[n-i-1];
          
          if(Sip1 > max){
              max = Sip1;
          }
          Si = Sip1;
       }
      return max;
    }	
}
