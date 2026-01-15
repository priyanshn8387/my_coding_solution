class Solution {

    public int findCount(String s1, String s2, int i, int j, int [][] dp){

        if(i==0 && j==0){
            if(s1.charAt(i)==s2.charAt(j)) return 1;
            return 0;
        }

        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+findCount(s1,s2,i-1,j-1,dp);
        }else{
            return dp[i][j]=Math.max(findCount(s1,s2,i,j-1,dp),findCount(s1,s2,i-1,j,dp));
        }

        

    }
    public int longestCommonSubsequence(String text1, String text2) {
        
        if(text1.length()==0 && text2.length()==0) return 0;
        int[][] dp = new int[text1.length()][text2.length()];
        for(int [] row : dp) Arrays.fill(row,-1);

        return findCount(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
}