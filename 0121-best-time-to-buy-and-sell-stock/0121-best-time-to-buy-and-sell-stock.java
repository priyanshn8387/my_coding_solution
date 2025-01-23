class Solution {
    public int maxProfit(int[] prices) {
        
        int min_elem = prices[0];
        int profit =0;


        for(int i=1;i<prices.length;i++){
            if(prices[i]>min_elem){
                profit = Math.max(profit,prices[i]-min_elem);
            }

            min_elem = Math.min(min_elem,prices[i]);
        }

        return profit;
    }
}