class Solution {

    public int recur(int[] coins, int index, int amount, int[][] dp) {
        if (amount == 0) return 1;
        if (index == 0) {
            return (amount % coins[index] == 0) ? 1 : 0;
        }

        if (dp[index][amount] != -1) return dp[index][amount];

        int pick = 0;
        if (amount >= coins[index]) {
            pick = recur(coins, index, amount - coins[index], dp); // it can also
            
        }

        int notPick = recur(coins, index - 1, amount, dp);

        return dp[index][amount] = pick+notPick;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int index = n - 1;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int val = recur(coins, index, amount, dp);

        return (val == Integer.MAX_VALUE ? 0 : val);
    }
}
