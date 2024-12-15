class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int currSum = 0;
        int  minLength = Integer.MAX_VALUE;

        int left=0,right=0;

        while(right<nums.length){
            currSum+=nums[right];

            while(currSum>=target){
                minLength = Math.min(minLength,right-left+1);
                currSum-=nums[left];
                left++;
            }
            right++;



        }

        return (minLength ==  Integer.MAX_VALUE ? 0 : minLength);
    }
}