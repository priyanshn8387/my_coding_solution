class Solution {
    public int findTargetSumWays(int[] nums, int k) {

        if (nums == null || nums.length == 0) return 0;

        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // Invalid cases
        if (totalSum < Math.abs(k) || (totalSum + k) % 2 != 0) return 0;

        int target = (totalSum + k) / 2;

        // dp[i][t] = number of ways to make sum t using first i elements
        int[][] dp = new int[nums.length][target + 1];

        // Base case
        if (nums[0] == 0) {
            dp[0][0] = 2;   // +0 and -0
        } else {
            dp[0][0] = 1;
            if (nums[0] <= target) dp[0][nums[0]] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int t = 0; t <= target; t++) {

                int notPick = dp[i - 1][t];
                int pick = 0;

                if (t >= nums[i]) {
                    pick = dp[i - 1][t - nums[i]];
                }

                dp[i][t] = pick + notPick;
            }
        }

        return dp[nums.length - 1][target];
    }
}
