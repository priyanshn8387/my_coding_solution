class Solution {
    // public int recur(int[] nums, int index, int [] dp){
    //     //1. base case
    //     if(index==0) return nums[0];
    //     if(index<0) return 0;

    //     //2. dp base case

    //     if(dp[index]!=-1) return dp[index];


    //     // 3. recursion equation

    //     int pick = nums[index]+recur(nums,index-2,dp);
    //     int notPick = 0+ recur(nums,index-1,dp);


    //     // 4. store answer in dp

    //     return dp[index]=Math.max(pick,notPick);
    // }
    public int rob(int[] nums) {
        int index = nums.length-1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);

        // 1. top down approach
       // int ans=recur(nums,index,dp); 
       // return ans;

       // 2. bottom up 
        dp[0]=nums[0];

        for(int i=1;i<nums.length;i++){
          
            int pick = nums[i]+ ((i-2<0) ? 0 :dp[i-2]);
            
            int notPick = 0+ dp[i-1];
            dp[i]=Math.max(pick,notPick);
        }

        return dp[index];




        
    }
}