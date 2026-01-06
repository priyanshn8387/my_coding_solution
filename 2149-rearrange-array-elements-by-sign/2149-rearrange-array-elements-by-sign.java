class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int[] res = new int[nums.length];
            int positive_idx = 0;
            int negative_idx = 1;
        for(int i=0;i<nums.length;i++){

            if(nums[i]>0){
                res[positive_idx] = nums[i];
                positive_idx = positive_idx+2;
            }else{
                res[negative_idx] = nums[i];
                negative_idx = negative_idx+2;
            }
        }

        return res;
    }
}