class Solution {
    public String largestNumber(int[] nums) {

        // Convert each integer in nums to a string
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        // Sort the strings based on custom comparator
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", return "0"
        if (str[0].equals("0")) return "0";

        // Build the result string
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }

        return sb.toString();

        
    }
}