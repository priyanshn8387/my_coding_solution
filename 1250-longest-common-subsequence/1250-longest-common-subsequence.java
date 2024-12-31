class Solution {

    public int recur(String text1, String text2, int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return (text1.charAt(i) == text2.charAt(j) ? 1 : 0);
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + recur(text1, text2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(recur(text1, text2, i - 1, j, dp), recur(text1, text2, i, j - 1, dp));
        }
    }

    public int recurShiftingIndex(String text1, String text2, int i, int j, int[][] dp) {
        if (i == 1 && j == 1) return (text1.charAt(i - 1) == text2.charAt(j - 1) ? 1 : 0);
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            return dp[i][j] = 1 + recurShiftingIndex(text1, text2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(recurShiftingIndex(text1, text2, i - 1, j, dp), recurShiftingIndex(text1, text2, i, j - 1, dp));
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        /* 1.top down
        int i = text1.length() - 1;
        int j = text2.length() - 1;

        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row : dp) Arrays.fill(row,-1);

        return recur(text1,text2,i,j,dp);

        */

        /*
        // 2.top down with shifting index
        int i = text1.length() - 1;
        int j = text2.length() - 1;

        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] row : dp) Arrays.fill(row,-1);

        return recurShiftingIndex(text1,text2,i+1,j+1,dp);

        */

        /* 3.tabulation

        int[][] dp = new int[text1.length()][text2.length()];

        if (text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        } else {
            dp[0][0] = 0;
        }

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + ( i>0 && j>0 ? dp[i-1][j-1] : 0);
                } else {
                    dp[i][j] = Math.max((i > 0 ? dp[i - 1][j] : 0),
                        (j > 0 ? dp[i][j - 1] : 0));
                }
            }
        }

        return dp[text1.length()-1][text2.length()-1];

        */

        /*
        // 4. tabulation with shifting index
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length() + 1; i++) dp[i][0] = 0;
        for (int j = 0; j < text2.length() + 1; j++) dp[0][j] = 0;

        if (text1.charAt(0) == text2.charAt(0)) {
            dp[1][1] = 1;
        } else {
            dp[1][1] = 0;
        }

        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];

        */


        // space optimised

        int[]prev = new int[text2.length() + 1];
        

        prev[0] = 0;
        // for (int j = 0; j < text2.length() + 1; j++) dp[0][j] = 0;

        if (text1.charAt(0) == text2.charAt(0)) {
            prev[1] = 1;
        } else {
            prev[1] = 0;
        }

        for (int i = 1; i < text1.length() + 1; i++) {
            int[]curr = new int[text2.length() + 1];
            curr[0] = 0;
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j-1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }

            prev=curr;
        }

        return prev[text2.length()];



        

    }
}
