import java.util.*;

public class H_03{

	public static int solution(String s) {
		int answer=0;
		HashMap<Character, Integer> memo = new HashMap<>();
		int release = 0;
		
		for(int acquire=0; acquire < s.length(); acquire++){
		    Character currentVal = s.charAt(acquire);
		    while(release < acquire && memo.containsKey(currentVal)){
		       Character disChar = s.charAt(release);
		       memo.remove(disChar);
		       release += 1;
		}
		memo.put(currentVal, 1);
		answer += acquire-release+1;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		System.out.println(solution(s));
	}

}
