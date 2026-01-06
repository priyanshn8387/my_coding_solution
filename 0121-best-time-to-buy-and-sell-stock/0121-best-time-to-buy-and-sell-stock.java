class Solution {
    public int maxProfit(int[] prices) {

        int minBuyStockValue = prices[0];
        int mini = Integer.MAX_VALUE;
        int maxProfit =0;

        for(int i=1;i<prices.length;i++){

            int currentDaySell = prices[i];
            maxProfit = Math.max(maxProfit,currentDaySell-minBuyStockValue);

            minBuyStockValue = Math.min(minBuyStockValue, prices[i]);
        }

        return maxProfit;



        
    }
}