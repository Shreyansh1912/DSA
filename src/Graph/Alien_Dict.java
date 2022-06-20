import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    String[] words = br.readLine().split(" ");

    System.out.println(alienOrder(words));
  }

  public static String alienOrder(String[] words) {
    
      //creating map for connection who came befor and after
      //use hashset for not to get dublicate, coz multiple time there is a lot of camparision
       HashMap<Character, HashSet<Character>> map = new HashMap<>();
       
      //calculating indegree of each sorted characters
       HashMap<Character,Integer> indegree = new HashMap<>();
       
      //logic for getting the indegree
      for( String str : words)
      {
          //stirng to character conversion
          for(char ch : str.toCharArray())
          {
              //initioally addingt the indegree as zero
              indegree.put(ch,0);
          }
      }
       
       //rather than comparing all the combinations we can check only two consecutive
       //coz given word are in sorted order
       for(int i = 0; i < words.length-1 ; i++)
       {
            
            //get the first and sec string
             String curr = words[i];
             String next = words[i+1];
             
             //getting there size coz we can compair it to the max one in min loop
             int len = Math.min(curr.length(), next.length());
             
             //there is edge case we have to handle it
             boolean flag = false;
             
             for(int j = 0 ; j < len ; j++)
             {
                 //get those cahracter
                 char ch1 = curr.charAt(j);
                 char ch2 = next.charAt(j);
                 
                 //compare them if not same who ever is first in dictionory will come first
                 //this case ch1 come first
                 if(ch1 != ch2 )
                 {
                     HashSet<Character> set = new HashSet<>();
                     
                         if(map.containsKey(ch1) == true)
                         {
                             set = map.get(ch1);
                             
                             if(set.contains(ch2) == false)
                             {
                                 //add that as set 
                                 set.add(ch2);
                                 //update their indegree
                                 indegree.put(ch2, indegree.get(ch2) + 1);
                                 //settng ch1 come first before ch2
                                 map.put(ch1, set);
                             }
                         }
                         else
                         {
                             //if not present add them in set
                             set.add(ch2);
                             //connect ch1 to ch2
                             map.put(ch1, set);
                             //update the indegree
                             indegree.put(ch2, indegree.get(ch2) + 1);
                         }
                   flag=true;
                   break;
                }
            
            }
            //if two word are same, hence flag still false
            //and first length is greater than the next one means input given wrong
            if(flag ==false && curr.length() > next.length())
            return "";
            
         
         
        }
    
    //use topological sorting/khan algorithm logic
       Queue<Character> qu = new LinkedList<>();
       StringBuilder ans = new StringBuilder();
       
       for(char ch : indegree.keySet())
       {
           if(indegree.get(ch) == 0)
                qu.offer(ch);
       }
       
       int count = 0;
       while(qu.size() > 0 )
       {
           char rem = qu.poll();
           count++;
           ans.append(rem);
           
           
           if(map.containsKey(rem) == true)
           {
               HashSet<Character> nbrs = map.get(rem);
               
               for(char nbr : nbrs)
               {
                   indegree.put(nbr, indegree.get(nbr) - 1);
                   if(indegree.get(nbr) == 0)
                   {
                       qu.offer(nbr);
                   }
               }
            }
       }
       
        if(count == indegree.size())
        return ans.toString();
        else
        return "";
        
    }
}
