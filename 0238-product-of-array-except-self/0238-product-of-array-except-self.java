class Solution {
    public int[] productExceptSelf(int[] nums) {



        int n = nums.length;

        int [] left = new int[n];
        int [] right = new int[n];

        left[0]=1;
        right[n-1]=1;
        int prodL=1;
        int prodR=1;

        for(int i=1;i<n;i++){
            prodL = prodL*nums[i-1];
            left[i]=prodL;
        }

        for(int i=n-2;i>=0;i--){
            prodR = prodR*nums[i+1];
            right[i]=prodR;
        }

        int [] res = new int[n];
        for(int i=n-1;i>=0;i--){
            res[i]=left[i]*right[i];
        }

        return res;
        
    }

    
}