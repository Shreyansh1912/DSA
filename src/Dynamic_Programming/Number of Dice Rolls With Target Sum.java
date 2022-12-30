class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        return totalWays(n, k, target, new HashMap<String, Integer>());
    }
    private int totalWays(int n, int f, int t, HashMap<String, Integer> memo){
        if(n == 0 && t == 0) return 1;

        if(n == 0 || t <= 0) return 0;
       
        String currentKey = n + "-" + t;

        if(memo.containsKey(currentKey))
         return memo.get(currentKey);

        int ways=0;
        int MOD = 1000000007;

        for(int i=1; i<=f; i++){
           int tempAns = totalWays(n-1, f, t-i, memo) % MOD;
           ways = ways % MOD;

           ways = (ways + tempAns) % MOD;
        }
        memo.put(currentKey, ways);
        return ways;
    }
}
