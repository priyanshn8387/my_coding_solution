class Solution {
    public int trap(int[] height) {

        int left=0;
        int right=height.length-1;
        int lmax=Integer.MIN_VALUE;
        int rmax=Integer.MIN_VALUE;
        int maxTrapWater=0;



        while(left<right){
            lmax=Math.max(lmax,height[left]);
            rmax=Math.max(rmax,height[right]);

            if(lmax<rmax){
                maxTrapWater+=lmax-height[left];
                left++;
            }else{
                maxTrapWater+=rmax-height[right];
                right--;
            }


        }

        return maxTrapWater;
        
    }
}