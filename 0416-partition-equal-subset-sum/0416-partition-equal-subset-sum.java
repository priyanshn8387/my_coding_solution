class Solution {

    public boolean isPartition(int[] nums, Boolean [][] dp, int target, int index){

        if(target==0) return true;
        if(index==0) return nums[index]==target;

        if(dp[index][target]!=null) return dp[index][target];
        boolean pick = false;
        if(target>=nums[index]){
            pick = isPartition(nums,dp,target-nums[index],index-1);
        }
        boolean notPick = isPartition(nums,dp,target,index-1);

        return dp[index][target] = pick || notPick;
        
    }
    public boolean canPartition(int[] nums) {

        if(nums==null || nums.length<=1) return false;
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }

        if(totalSum%2!=0) return false;
        int target = totalSum/2;

        Boolean[][] dp = new Boolean[nums.length][target+1];

        return isPartition(nums,dp,target,nums.length-1);
        
    }
}