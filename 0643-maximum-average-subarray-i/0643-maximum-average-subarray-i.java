class Solution {
    public double findMaxAverage(int[] nums, int k) {

        if(nums.length<k) return 0.0;

        double currSum=0;
        double maxSum = 0;
        
        for(int i=0;i<k;i++){
            currSum+=nums[i];
        }

        maxSum = currSum/k;

        for(int i=k;i<nums.length;i++){
            int incoming = nums[i];
            int outgoing = nums[i-k];

            currSum= currSum+incoming-outgoing;
           // currSum = currSum/k;

            maxSum=Math.max(maxSum,currSum/k);
        }

        return maxSum;
        
    }


}