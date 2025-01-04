class Solution {

    public int recur(String s, int index, int[]dp){

        if(index==s.length()) return 0;

        if(dp[index]!=-1) return dp[index];

        int min=Integer.MAX_VALUE;
        for(int i=index;i<s.length();i++){
            String partition = s.substring(index,i+1);
            if(isPalindrome(partition)){
                min=Math.min(min,1+recur(s,i+1,dp));
            }
        }


        return dp[index]=min;
    }

      public boolean isPalindrome(String s){
        int start=0;
        int end = s.length()-1;

        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return recur(s,0,dp)-1; // -1 coz,abc=> a|b|c| as per code it is giving 3 but we need 2
    }
}