class Solution {
    int minimumCost(int[] cost,int[] dp, int index){
        if(index==0) return cost[index];
        if(index==1) return cost[index];

        if(dp[index]!=-1) return dp[index];

        int oneStep = cost[index]+minimumCost(cost,dp,index-1);
        int twoStep = cost[index]+minimumCost(cost,dp,index-2);

        return dp[index]=Math.min(oneStep,twoStep);
    }
    public int minCostClimbingStairs(int[] cost) {

        if(cost == null || cost.length ==0) return 0;
        int n = cost.length;
        if(n==1) return cost[0];

        int []dp = new int[n];
        Arrays.fill(dp,-1);
        // Given in question can start from index 0 or 1
        return Math.min(minimumCost(cost,dp,n-1),minimumCost(cost,dp,n-2));
        
    }
}