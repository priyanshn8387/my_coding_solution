class Solution {

    public int recur(int i, int j, int[][] dp){

        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return 1;

        if(dp[i][j]!=-1) return dp[i][j];


        return dp[i][j]=recur(i-1,j,dp)+recur(i,j-1,dp);
    }
    public int uniquePaths(int m, int n) {

        int [][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row,-1);

        return recur(m-1,n-1,dp);
        
    }
}