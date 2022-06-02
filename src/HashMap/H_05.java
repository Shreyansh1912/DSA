import java.util.*;

public class Main {

	public static int solution(String s, int k) {
		HashMap<Character, Integer> memo = new HashMap<>();
		int answer=0;
		int distinct=0;
		int release=0;
		
		for(int acquire=0; acquire < s.length(); acquire++)
		{
		      Character currentChar = s.charAt(acquire);
		      if(memo.containsKey(currentChar)){
		          memo.put(currentChar, memo.get(currentChar)+1);
		      }
		      else{
		          memo.put(currentChar, 1);
		          distinct+=1;
		      }
		
		while(distinct > k)
		{
		    Character disChar = s.charAt(release);
		    release+=1;
		    
		    memo.put(disChar, memo.get(disChar)-1);
		    if(memo.get(disChar) == 0)
		    {
		        memo.remove(disChar);
		        distinct -= 1;
		     }
		   
	   	}
		 answer += acquire-release+1;
	  }
	   return answer;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(s,k));
	}

}
