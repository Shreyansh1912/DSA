class Solution {
    public int maxProfit(int[] prices, int fee) {
        return maximumProfit(prices, 0, 1, new HashMap<String, Integer>(), fee);
    }
    private int maximumProfit(int[] prices, int currentDay, int canBuy, HashMap<String, Integer> memo, int fee){

        if(currentDay >= prices.length)
            return 0;

        String currentKey = currentDay + "-" + canBuy;

        if(memo.containsKey(currentKey))
          return memo.get(currentKey);

        int ans=0;  
        if(canBuy == 1){
            int idle = maximumProfit(prices, currentDay + 1, canBuy, memo, fee);
            int buy = -prices[currentDay] + maximumProfit(prices, currentDay + 1, 0, memo, fee);
            ans = Math.max(idle, buy);
        } else{
           int idle = maximumProfit(prices, currentDay + 1, canBuy, memo, fee);
           int sell = -fee + prices[currentDay] + maximumProfit(prices, currentDay + 1, 1, memo, fee);
           ans = Math.max(idle, sell);
        }   
        memo.put(currentKey, ans);
        return ans;
    }
}
