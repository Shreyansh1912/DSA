// { Driver Code Starts
import java.util.Scanner;

class GfG
{
	public static void main(String args[])
	{
		 Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
		 {
			MyQueue obj = new MyQueue();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					
					obj.push(a);
					
				}else if(QueryType == 2)
				{
				System.out.print(obj.pop()+" ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		 }
	}
}



// } Driver Code Ends

//All operation done in O(1)
class MyQueue {

    int front=-1, rear=-1;
	int size = 100005;
	int arr[] = new int[size]; ;

   boolean isFull() {
        return (rear + 1) % size == front;
        }
        
    boolean isEmpty() {
        return rear == -1 && front == -1;
        }
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	   if (isFull()) {
        //System.out.println("Overflow");
            return;
        }
            //if it's the 1st element
          if (front == -1) {
                front = 0;
        }

            rear = (rear + 1) % size;
            arr[rear] = x;
    }
    //Function to pop an element from queue and return that element.
	int pop()
	{
	    if(isEmpty()) {
           return -1;
        }
            int res = arr[front];

            //if only 1 element is present
            if(front == rear) {
                front = rear = -1;
            } else {
                front = (front+1)%size;
            }

            return res;
        }
}



