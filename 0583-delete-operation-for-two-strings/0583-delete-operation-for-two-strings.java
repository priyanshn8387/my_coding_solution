class Solution {

    public int LCS(String text1, String text2, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return (text1.charAt(i) == text2.charAt(j) ? 1 : 0);
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + LCS(text1, text2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(LCS(text1, text2, i - 1, j, dp), LCS(text1, text2, i, j - 1, dp));
        }
    }

    public int minDistance(String word1, String word2) {
        int i = word1.length() - 1;
        int j = word2.length() - 1;

        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] row : dp) Arrays.fill(row, -1);

        //understand like this
        // sea(word1)         eat(word2)

        //        ea(common,LCS)

        // now we need to make word1 = word2 (that means we have lcs which is same for both)
        // now for word1, we need to remove s to make to ea =>word1.length()-lcs
        // now for word2, we need to remove t to make to ea =>word2.length()-lcs

        // net net => word1.length()+word2.length()-2*LCS

        return word1.length() + word2.length() - 2 * LCS(word1, word2, i, j, dp);
    }
}
