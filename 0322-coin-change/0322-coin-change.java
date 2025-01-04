class Solution {

    public int recur(int[] coins,int index,int amount,int[][] dp){

        if(amount==0) return 0;
        if(index==0){
            if(amount%coins[index]==0) return amount/coins[index];
            else return Integer.MAX_VALUE;
        }

        if(dp[index][amount]!=-1) return dp[index][amount];

        int pick =Integer.MAX_VALUE;
        if(amount>=coins[index]){
            int result = recur(coins, index, amount - coins[index], dp); // it can also 
           // give max value as well
            if (result != Integer.MAX_VALUE) {
                pick = 1 + result; 
            }
        }

        int notPick = recur(coins,index-1,amount,dp);

        return dp[index][amount]= Math.min(pick,notPick);
        
    }
    public int coinChange(int[] coins, int amount) {

        int n=coins.length;
        int index=n-1;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        
        int val = recur(coins,index,amount,dp);
        
        return (val==Integer.MAX_VALUE ? -1 : val);
        
    }
}