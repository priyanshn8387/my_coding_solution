class Solution {
    public int pivotIndex(int[] nums) {

        int n = nums.length;

        int leftSum=0;
        int rightSum=0;
        for(int i=0;i<n;i++){
            rightSum+=nums[i];
        }

        int res = -1;

        for(int i=0;i<n;i++){
            rightSum-=nums[i];

            if(leftSum==rightSum){
                res = i;
                break;
            }

            leftSum+=nums[i]; 
        }

        return res;
        
    }
}