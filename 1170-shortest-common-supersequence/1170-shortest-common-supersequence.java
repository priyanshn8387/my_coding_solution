class Solution {

    public int[][] tabulationLCS(String text1, String text2) {
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
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        // here supersequence is adding both string => abac cab
        // now common subsequence = ab
        //shortest is => supersequence-common subsequence , if they want us to return number
        // but they here want to print, so wee need tabulation of lcs

        int[][] dp = tabulationLCS(str1, str2);

        int i = str1.length();
        int j = str2.length();

        StringBuilder ans = new StringBuilder();

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                ans.append(str2.charAt(j - 1));
                j--;
            } else {
                ans.append(str1.charAt(i - 1));
                i--;
            }
        }

        while (i > 0) {
            ans.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            ans.append(str2.charAt(j - 1));
            j--;
        }

        return ans.reverse().toString();
    }
}
