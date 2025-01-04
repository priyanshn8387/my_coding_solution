class Solution {

    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};

    public int recur(int i, int j, int[][] matrix, int[][] dp){

        if(dp[i][j]!=-1) return dp[i][j];

        int max = 1;
        for(int [] dir : directions ){
            int i_ = i+ dir[0];
            int j_ = j+dir[1];

            if(i_>=0 && j_>=0 && i_<matrix.length && j_<matrix[0].length && matrix[i][j]>matrix[i_][j_]){
                max=Math.max(max,1+recur(i_,j_,matrix,dp));
            }
        
        }
        return dp[i][j]=max; // returning the max length LIP at this cell.

    }
    public int longestIncreasingPath(int[][] matrix) {

        int n= matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row,-1);

        // at every cell, there is four options left,right,top, down
        //here you need to first calculate at each cell how many LIP are formed like.
        // at index(0,0) -> 9 6 2 1 and no other are there
        // so we need to return the max length of LIP from every cell;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans,recur(i,j,matrix,dp));
            }
        }

        return ans;
    }
}