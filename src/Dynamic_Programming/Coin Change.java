class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = noOfWays(coins, 0, amount, new HashMap<String, Integer>());

        if(ans == 10001) 
           return -1;

        return ans;
    }
    private int noOfWays(int[] coins, int currentIndex, int amt, HashMap<String, Integer> memo){
       if(amt == 0) return 0;

       if(currentIndex == coins.length) return 10001;

       int currentCoin = coins[currentIndex];
           
       String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(amt);
        
        if(memo.containsKey(currentKey))
          return memo.get(currentKey);
        
        int consider = 10001;
          if(currentCoin <= amt)
        consider = 1+ noOfWays(coins, currentIndex, amt - currentCoin, memo);

       int notConsider = noOfWays(coins, currentIndex + 1, amt, memo); 

        memo.put(currentKey, Math.min(consider , notConsider));
        return memo.get(currentKey);
    }
}
