class Solution {

    public int maximumMoney(int[] nums, int[] dp , int index){

        if(index==0) return nums[index];
        if(index==1) return Math.max(nums[index-1],nums[index]); // two houses will be there, yaa tou pehla ya dusra lootengey tou jo maxium hoga vhi lutengety.

        if(dp[index]!=-1) return dp[index];
 
        int take = nums[index]+maximumMoney(nums,dp,index-2);

        int notTake = 0+maximumMoney(nums,dp,index-1);

        return dp[index]=Math.max(take,notTake);

    }
    public int rob(int[] nums) {
        int n = nums.length;
        // int [] dp = new int[n]; // not required n+1, coz f(4) can be stored in n size array
        // Arrays.fill(dp,-1);

        // return maximumMoney(nums,dp,n-1);


        // bottom up 

         // base case for nums array
         if (nums.length == 0) return 0; // Handle edge case where nums is empty
          if (nums.length == 1) return nums[0]; // Handle edge case with a single house

        int [] dp = new int[n]; 
        dp[0]=nums[0];
        dp[1]= Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            int take = nums[i]+dp[i-2];
            int notTake = 0+dp[i-1];

            dp[i]=Math.max(take,notTake);
        }

        return dp[n-1]; // since we are building from last then ans will be stored in top f(4);
    }
}