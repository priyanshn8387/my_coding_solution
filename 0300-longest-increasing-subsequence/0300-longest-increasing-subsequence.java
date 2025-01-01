class Solution {

    public int LIS(int[] nums, int index, int nextIndex, int[][] dp) {

        // if (index == 0) {
        //     if (nextIndex == nums.length || nums[nextIndex] > nums[index]) return 1; else return 0;
        // }
        // this above base condition is redundant, if you put index =0 in LIS call , it going into 1+LIS() call , so not taking this base condition.

        if (index < 0) return 0;

        if (dp[index][nextIndex] != -1) return dp[index][nextIndex];

        int pick = 0;
        if (nextIndex == nums.length || nums[nextIndex] > nums[index]) {
            pick = 1 + LIS(nums, index - 1, index, dp);
        }

        int notPick = LIS(nums, index - 1, nextIndex, dp);

        return dp[index][nextIndex] = Math.max(pick, notPick);
    }

    public int lengthOfLIS(int[] nums) {
        int index = nums.length - 1;
        int next = nums.length;

        int[][] dp = new int[nums.length][nums.length + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        // Here 10,9,2,5,3,7,101, 18
        //                       index
        //                              next
        // next is used for comparing , if we start from first then we could have used prev=-1
        // but here we starting from last , so took next. 

        return LIS(nums, index, next, dp);
    }
}
