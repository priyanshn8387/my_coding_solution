class Solution {

     public int LPS(String text1, String text2, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return (text1.charAt(i) == text2.charAt(j) ? 1 : 0);
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + LPS(text1, text2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(LPS(text1, text2, i - 1, j, dp), LPS(text1, text2, i, j - 1, dp));
        }
    }

    public int minInsertions(String s) {

        String s1= s;
        StringBuilder sb = new StringBuilder(s);
        String s2= sb.reverse().toString();

        int i=s1.length()-1;
        int j= s2.length()-1;

        //here s1->mbadm           s2->mdabm
        // 
        //                mbm(LPS)   

        // so we can say s1 length - lps , will give minimum insertion    

        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] row : dp) Arrays.fill(row,-1);

        return s1.length()-LPS(s1,s2,i,j,dp);
        
    }
}