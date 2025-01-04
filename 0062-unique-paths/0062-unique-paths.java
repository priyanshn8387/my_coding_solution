class Solution {

    public int findPath(int i, int j, int[][] dp){

        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        if(dp[i][j]!= -1) return dp[i][j];

        return dp[i][j]=findPath(i-1,j,dp)+findPath(i,j-1,dp);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
         for (int[] row : dp) {
            Arrays.fill(row, -1); // fill each row with -1
        }
        return findPath(m-1,n-1,dp);
    }
}