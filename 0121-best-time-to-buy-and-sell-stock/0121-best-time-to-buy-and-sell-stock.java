class Solution {
    public int maxProfit(int[] prices) {

        int low =0;
        int high =1;
        int maxProfit =0;

        while(high<prices.length){
            maxProfit=Math.max(maxProfit,prices[high]-prices[low]);
            if(prices[low]>prices[high]){
                low=high;
            }
            high++;
        }

        return maxProfit;
        


        
    }
}