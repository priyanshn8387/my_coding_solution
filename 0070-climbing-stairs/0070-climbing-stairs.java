class Solution {

    int recur(int[] dp, int index){

        //if(index==0) return 0; 
        // to make it compatible for f(2)=f(1)+f(1)=1+1=2
        if(index==0) return 1;
        if(index==1) return 1;
        if(dp[index]!=-1) return dp[index];

        return dp[index]=recur(dp,index-1)+recur(dp,index-2);
    }
    public int climbStairs(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int index = n;
        return recur(dp,index);
        
    }
}