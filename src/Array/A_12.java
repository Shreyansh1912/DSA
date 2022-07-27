//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Complete obj = new Complete();
		    ArrayList<Integer> ans;
		    ans = obj.square(arr, sizeOfArray);
		    for(int i: ans)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static ArrayList<Integer> square (int arr[], int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int ele : arr){
            if(hm.containsKey(ele) == true){
             int nf = hm.get(ele) + 1;
             hm.put(ele, nf);
            } else{
                hm.put(ele, 1);
            }
        }
        
        int max_area= 0;
        int sq=0;
        
        for(int key:hm.keySet()){
            int freq = hm.get(key);
            if(freq >= 4){
                int area = key*key;
                
                if(area > max_area){
                    max_area = area;
                    sq=freq/4;
                } 
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(max_area == 0){
            ans.add(-1);
        }else{
            ans.add(max_area);
            ans.add(sq);
        }
        return ans;
    }
  }


