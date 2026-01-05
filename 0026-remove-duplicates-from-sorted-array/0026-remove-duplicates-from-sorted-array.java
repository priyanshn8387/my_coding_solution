class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums.length==1) return 1;

        int left=0;
        int right=0;
        int count=0;


        while(right<nums.length){
            if(nums[right]!=nums[left]){
                nums[left+1]=nums[right];
                count++;
                left=left+1;
            }
            right++;
        }

        return count+1;

        
        
    }
}