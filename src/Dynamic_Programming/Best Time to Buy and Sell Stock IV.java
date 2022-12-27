class Solution {
    public int maxProfit(int k, int[] prices) {
        return maximumProfit(prices, 0, 1, k, new HashMap<String, Integer>());
    }
    private int maximumProfit(int[] prices, int currentDay, int canBuy, int transCount, HashMap<String, Integer> memo){

        if(currentDay >= prices.length || transCount == 0)
            return 0;
        
        String currentKey = currentDay + "-" + canBuy + "-" + transCount;

        if(memo.containsKey(currentKey))
          return memo.get(currentKey);

        int ans=0;  
        if(canBuy == 1){
            int idle = maximumProfit(prices, currentDay + 1, canBuy, transCount, memo);
            int buy = -prices[currentDay] + maximumProfit(prices, currentDay + 1, 0, transCount, memo);
            ans = Math.max(idle, buy);
        } else{
           int idle = maximumProfit(prices, currentDay + 1, canBuy, transCount, memo);
           int sell = prices[currentDay] + maximumProfit(prices, currentDay + 1, 1, transCount - 1, memo);
           ans = Math.max(idle, sell);
        }   
        memo.put(currentKey, ans);
        return ans;
    }
}
