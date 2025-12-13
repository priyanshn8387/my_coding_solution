class Solution {
    public int pivotIndex(int[] nums) {

        int n = nums.length;

        int [] left = new int[n];
        int [] right = new int[n];

        left[0]=0;
        right[n-1]=0;
        int prodL=0;
        int prodR=0;

        for(int i=1;i<n;i++){
            prodL = prodL+nums[i-1];
            left[i]=prodL;
        }

        for(int i=n-2;i>=0;i--){
            prodR = prodR+nums[i+1];
            right[i]=prodR;
        }

        int res = -1;
        for(int i=0;i<nums.length;i++){
            if(left[i]==right[i]){
                res = i;
                break;
            } 
        }

        return res;
        
    }
}