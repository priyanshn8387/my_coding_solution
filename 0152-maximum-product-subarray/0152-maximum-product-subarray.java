class Solution {
    public int maxProduct(int[] nums) {

        if(nums.length==1) return nums[0];
        int mult=1;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            mult=mult*nums[i];
            maxi=Math.max(maxi,mult);
            if(mult==0) mult=1;
        }
        mult =1;
         for(int i=nums.length-1;i>=0;i--){
            mult=mult*nums[i];
            maxi=Math.max(maxi,mult);
            if(mult==0) mult=1;
        }
        return maxi;
    }
}