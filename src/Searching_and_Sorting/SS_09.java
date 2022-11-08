//{ Driver Code Starts
//Initial Template for Java



//Initial Template for Java



import java.io.*;
        import java.util.*;

class node
{
    int marks;
    int index;
    public void setMarks(int a)
    {
        this.marks=a;
    }
    public void setIndex(int b)
    {
        this.index=b;
    }
}

class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            node a[]=new node[n];
            for(int i=0;i<n;i++) {
                a[i] = new node();
                a[i].setMarks(Integer.parseInt(q[i]));
                a[i].setIndex(i);
            }

            int k = Integer.parseInt(br.readLine());
            GFG ob = new GFG();
            ob.kTop(a,n);
            int i=0;
            for(int j=0;j<k;j++)
            {
                int x=a[i].marks;
                while(i<n && a[i].marks==x) {
                    System.out.print(a[i].index + " ");
                    i++;
                }
                if (i == n)
                    break;
            }
            System.out.println();

        }
    }
}



// } Driver Code Ends


//User function Template for Java


/* class node
{
    int marks;
    int index;
    public void setMarks(int a)
    {
        this.marks=a;
    }
    public void setIndex(int b)
    {
        this.index=b;
    }
}
*/

class GFG
{
    void kTop(node a[],int n)
    {
      Arrays.sort(a,(a1,a2)->(a2.marks-a1.marks));
    }
}


