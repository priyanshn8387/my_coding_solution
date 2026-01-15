class Solution {

    public int recur(String s, int index, int[] dp) {

        // Successfully decoded entire string
        if (index == s.length()) return 1;

        // Cannot decode starting with '0'
        if (s.charAt(index) == '0') return 0;

        // Memoization
        if (dp[index] != -1) return dp[index];

        // Single digit decode
        int singleDigitPartition = recur(s, index + 1, dp);

        // Double digit decode
        int doubleDigitPartition = 0;
        if (index + 1 < s.length() &&
            (s.charAt(index) == '1' ||
            (s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))) {

            doubleDigitPartition = recur(s, index + 2, dp);
        }

        return dp[index] = singleDigitPartition + doubleDigitPartition;
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return recur(s, 0, dp);
    }
}
