// { Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}


// } Driver Code Ends

class GfG
{
int minEle = Integer.MAX_VALUE;
   Stack<Integer> s = new Stack<>();

   /*returns min element from stack*/
   int getMin()
   {
      if(s.isEmpty())
         return -1;
     else
         return minEle;
   }
   
   /*returns poped element from stack*/
   int pop()
   {
       if(s.isEmpty())
          return -1;
       else{
    if(s.peek() >= minEle)
    {
        int a = s.peek();
        s.pop();
        return a;
    }
    else{
        int a = minEle;
        minEle = 2*minEle - s.peek();
        s.pop();
        return a;
        
    }
}

   }

   /*push element x into the stack*/
   void push(int x)
   {
   if(s.isEmpty())
   {
    s.push(x);
    minEle = x;
   
   }
   else{
      if(x >= minEle){
       s.push(x);
        }
     else
     {
       s.push(2*x-minEle);
       minEle = x;
      }
    }
   } 
}
 
