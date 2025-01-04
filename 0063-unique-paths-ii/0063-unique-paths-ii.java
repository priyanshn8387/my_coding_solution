class Solution {

    public int recur(int[][] obstacleGrid, int i,int j, int[][] dp){

        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return(obstacleGrid[i][j]==1 ? 0 : 1);

        if(obstacleGrid[i][j]==1) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        return dp[i][j]= recur(obstacleGrid,i-1,j,dp)+recur(obstacleGrid,i,j-1,dp);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m=obstacleGrid.length;
        int n= obstacleGrid[0].length;

        int [][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row,-1);

        return recur(obstacleGrid,m-1,n-1,dp);
        
    }
}