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
        
        int len = nums.length;
        if (len == 1) return nums[0];



        
        int [] excludingFirst =  new int[len-1];
        int [] excludingLast  = new int[len-1];
        int j=0;
        int k=0;

        for(int i=0;i<len;i++){
            if(i>0){
                excludingFirst[j]=nums[i];
                j++;
            }
            if(i<len-1){
                excludingLast[k]=nums[i];
                k++;
            }
        }

        int [] dp1 = new int[len-1];
        Arrays.fill(dp1,-1);
        int [] dp2 = new int[len-1];
        Arrays.fill(dp2,-1);

        //After preparing two arrays now its same like common house robber problem
        return Math.max(maximumMoney(excludingFirst,dp1,len-2),maximumMoney(excludingLast,dp2,len-2));

    }
}