class Solution {
    public int change(int amount, int[] coins) {
        return noOfWays(coins, 0, amount, new HashMap<String, Integer>());
    }
    private int noOfWays(int[] coins, int currentIndex, int amt, HashMap<String, Integer> memo){
       if(amt == 0) return 1;

       if(currentIndex >= coins.length) return 0;

       int currentCoin = coins[currentIndex];
           
        String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(amt);
        
        if(memo.containsKey(currentKey))
          return memo.get(currentKey);
        
        int consider = 0;
          if(currentCoin <= amt)
        consider = noOfWays(coins, currentIndex, amt - currentCoin, memo);

       int notConsider = noOfWays(coins, currentIndex + 1, amt, memo); 

        memo.put(currentKey, consider + notConsider);
        return memo.get(currentKey);
    }
}
