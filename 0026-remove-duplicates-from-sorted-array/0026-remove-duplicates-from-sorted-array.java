class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums==null || nums.length<1) return 0;
        if(nums.length==1) return 1;

        int left=0;
        int right=1;

        while(right<nums.length){
            if(nums[left]==nums[right]) right++;
            else{
                left++;
                nums[left]=nums[right];
                right++;
            } 

        }

        return left+1;

        
    }

    // Points for cleaner code
    // 1. you can remove the edge cases if(nums.length==1) return 1;, this below while loop handles it
    // 2. redundant right ++, make it below of if,else
}