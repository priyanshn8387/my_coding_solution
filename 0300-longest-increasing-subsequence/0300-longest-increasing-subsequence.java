class Solution {

    public int LIS(int[] nums, int index, int nextIndex, int[][] dp){

        if (index < 0) return 0;

        if(dp[index][nextIndex]!=-1) return dp[index][nextIndex];

        int pick = 0;
        if(nextIndex == nums.length || nums[nextIndex]>nums[index]){
            pick = 1 + LIS(nums,index-1,index,dp);
        }

        int notPick = LIS(nums,index-1,nextIndex,dp);

        return dp[index][nextIndex] = Math.max(pick,notPick);
    }
    public int lengthOfLIS(int[] nums) {
        
        int index = nums.length-1;
        int next = nums.length;

        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] row : dp) Arrays.fill(row,-1);


        return LIS(nums,index,next,dp);
    }
}