class Solution {

    public boolean recur(String s, List<String> wordDict, int index, Boolean[] dp){

        // Base Case: If we reach the end of the string, return true
        if (index == s.length()) {
            return true;
        }

        // If already computed, return the stored result
        if (dp[index] != null) return dp[index];

        // Try every possible partition starting from the current index
        for (int i = index; i < s.length(); i++) {
            String partition = s.substring(index, i + 1);
            if (wordDict.contains(partition) && recur(s, wordDict, i + 1, dp)) {
                return dp[index] = true;
            }
        }

        // If no partition works, mark as false
        return dp[index] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {

        int index = 0;
        Boolean[] dp = new Boolean[s.length()];
        /*
        boolean [] dp = new boolean[s.length()];
        The dp array is initialized as a boolean[] of size s.length(), but this does not    
        allow   
        differentiation between "not yet computed" and false. This causes logical errors.
        Fix: Use a Boolean[] array to allow null values for uninitialized states.

        */
        return recur(s,wordDict,index,dp);
        
    }
}