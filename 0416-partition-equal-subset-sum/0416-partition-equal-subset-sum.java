class Solution {

    public boolean recur(int[] nums, int index, int target, int[][] dp) {
        if (target == 0) return true;

        if (index == 0) return (nums[index] == target ? true : false);

        if (dp[index][target] != -1) return (dp[index][target] == 1 ? true : false);

        boolean pick = false;
        if (target >= nums[index]) {
            pick = recur(nums, index - 1, target - nums[index], dp);
        }

        boolean notPick = recur(nums, index - 1, target, dp);

        dp[index][target] = (pick || notPick) ? 1 : 0;
        return (pick || notPick);
    }

    /* top-down approach
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        // if number is odd, cant be partioned, so returning false
        if (totalSum % 2 != 0) return false;

        // if its even then proceed with half value

        int index = nums.length - 1;
        int[][] dp = new int[n][totalSum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return recur(nums, index, totalSum / 2, dp);
    }
    */

    /* bottom up
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        // if number is odd, cant be partioned, so returning false
        if (totalSum % 2 != 0) return false;

        // if its even then proceed with half value
        int target = totalSum / 2;
        int index = nums.length - 1;
        boolean[][] dp = new boolean[n][totalSum + 1]; // took boolean value

        // converting base cases
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int t = 0; t <= target; t++) {
            if (nums[0] == t) dp[0][t] = true;
        }

        // now iterate over loop i=0 and j=0 already solved

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean pick = false;
                if (j >= nums[i]) {
                    pick = dp[i-1][j - nums[i]];
                    
                }

                boolean notPick = dp[i-1][j];

                dp[i][j] = (pick || notPick);
                
            }
        }

        return dp[n-1][target];
    }
    */

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        // if number is odd, cant be partioned, so returning false
        if (totalSum % 2 != 0) return false;

        // if its even then proceed with half value
        int target = totalSum / 2;
        int index = nums.length - 1;

        boolean[] prev = new boolean[target+1];
       

        // converting base cases, this means 0th column must be true,
        // for (int i = 0; i < n; i++) {
        //     dp[i][0] = true;
        // }
        // so converting for 1d array
        prev[0]=true;
      

        for (int t = 0; t <= target; t++) {
            if (nums[0] == t) prev[t] = true;
        }

        // now iterate over loop i=0 and j=0 already solved
        // replacing dp[i-1] to prev and dp[i] to curr
        // 

        for (int i = 1; i < n; i++) {

            boolean[] curr = new boolean[target+1];
            curr[0]=true;
            
            for (int j = 1; j <= target; j++) {
                boolean pick = false;
                if (j >= nums[i]) {
                    pick = prev[j - nums[i]];
                }

                boolean notPick = prev[j];

                curr[j] = (pick || notPick);
            }

            // changing refernce 
            prev = curr;
        }

        return prev[target];
    }
}
