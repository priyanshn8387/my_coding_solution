class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int left=0,right=0;
        int mult=1;
        int totalSubarrayCount =0;
        int windowSubarrayCount = 0;

        if(k<=1) return 0; // base case


        while(right<nums.length){
            mult=mult*nums[right];

            // if(mult<k){ // expansion phase
            //     windowSubarrayCount = right-left+1;
            //     totalSubarrayCount+=windowSubarrayCount;
            // }

            if(mult>=k){ // shrinking phase
                while(mult>=k){
                    int outgoing = nums[left];
                    mult=mult/outgoing;
                    left++;
                }
            }

            windowSubarrayCount = right-left+1;
            totalSubarrayCount+=windowSubarrayCount;

            right++;
        }

        return totalSubarrayCount;
        
    }
}