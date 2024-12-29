class Solution {

    public boolean recur(int[] nums,int index,int target,int[][] dp){

        if(target==0) return true;

        if(index==0) return( nums[index]==target ? true : false);

        if(dp[index][target]!=-1) return (dp[index][target]==1 ? true : false);

        boolean pick = false;
        if(target>=nums[index]){
            pick = recur(nums,index-1,target-nums[index],dp);
        }

        boolean notPick = recur(nums,index-1,target,dp);

        dp[index][target] = (pick || notPick) ? 1 : 0 ; 
        return (pick || notPick);

        
    }
    public boolean canPartition(int[] nums) {

        int totalSum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        // if number is odd, cant be partioned, so returning false
        if(totalSum%2!=0) return false;

        // if its even then proceed with half value

        int index=nums.length-1;
        int[][] dp = new int[n][totalSum+1];
        for(int[] row : dp) Arrays.fill(row,-1);

        return recur(nums,index,totalSum/2,dp);
        
    }
}