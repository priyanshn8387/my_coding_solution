class Solution {

    public int recur(String text1, String text2, int i, int j, int[][] dp) {
        
        if(i==0 && j==0) return(text1.charAt(i)==text2.charAt(j) ? 0 : 1);
        if(i<0) return j+1;
        if(j<0) return i+1;

        if (dp[i][j] != -1) return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = recur(text1, text2, i - 1, j - 1, dp);
        } else {
            int delete = 1+recur(text1,text2,i-1,j,dp);
            int replace = 1+recur(text1,text2,i-1,j-1,dp);
            int insert = 1+recur(text1,text2,i,j-1,dp);
            return dp[i][j] = Math.min(delete,Math.min(replace,insert));
        }
    }

    public int minDistance(String word1, String word2) {
        int i = word1.length() - 1;
        int j = word2.length() - 1;

        // Here you cant solve with lcs, coz here it involve insert, deletin and replace all 
        // operation, in earlier we only have one operation in lcs
        // we want minimum operation => min(inserion,deletion,replacement)

        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] row : dp) Arrays.fill(row, -1);

        return recur(word1, word2, i, j, dp);
    }
}
