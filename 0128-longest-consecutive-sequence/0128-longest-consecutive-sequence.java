class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        Set<Integer> ss = new HashSet<>();
        for (int num : nums) {
            ss.add(num);
        }

        int maxi = 1;

        // 🔥 iterate over set, not array
        for (int num : ss) {

            int startingNumber = num;

            if (!ss.contains(startingNumber - 1)) {

                int count = 1;

                while (ss.contains(startingNumber + 1)) {
                    startingNumber++;
                    count++;
                }

                maxi = Math.max(maxi, count);
            }
        }

        return maxi;
    }
}
