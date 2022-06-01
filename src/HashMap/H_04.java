class H_04 {
    public int lengthOfLongestSubstring(String s) {
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
		answer = Math.max(answer, acquire-release+1);
		}
		return answer;
	}
}
