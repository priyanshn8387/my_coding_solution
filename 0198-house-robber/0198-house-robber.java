class Solution {

    public int maximumMoney(int[] nums, int[] dp , int index){

        if(index==0) return nums[index];
        if(index==1) return Math.max(nums[index-1],nums[index]);

        if(dp[index]!=-1) return dp[index];
 
        int take = nums[index]+maximumMoney(nums,dp,index-2);

        int notTake = 0+maximumMoney(nums,dp,index-1);

        return dp[index]=Math.max(take,notTake);

    }
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return maximumMoney(nums,dp,n-1);
    }
}