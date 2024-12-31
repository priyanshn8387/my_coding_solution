class Solution {

    public int recur(String text1, String text2, int i, int j, int[][] dp){

        if(i==0 && j==0) return(text1.charAt(i)==text2.charAt(j) ? 1 : 0);
        if(i<0 || j<0 ) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(text1.charAt(i)==text2.charAt(j)){
            return dp[i][j] = 1+ recur(text1,text2,i-1,j-1,dp);
        }else{
            return dp[i][j]=Math.max(recur(text1,text2,i-1,j,dp),recur(text1,text2,i,j-1,dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int i=text1.length()-1;
        int j = text2.length()-1;

        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row : dp) Arrays.fill(row,-1);

        return recur(text1,text2,i,j,dp);
        
    }
}