class Solution {

    public int minimumDeleteSum(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        // DP array to store the ASCII sum of the LCS
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Calculate total ASCII sum of both strings
        int totalASCIISum = 0;
        for (char c : s1.toCharArray()) totalASCIISum += c;
        for (char c : s2.toCharArray()) totalASCIISum += c;

        // Subtract 2 * LCS ASCII sum (characters not deleted)
        int lcsASCIISum = dp[m][n];
        return totalASCIISum - 2 * lcsASCIISum;
        


        
    }
}