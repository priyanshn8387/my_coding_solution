class Solution {
    public int[] productExceptSelf(int[] nums) {

       // here it clearly says you cant use divide
       // so need to think of another approach
       // 1,2,3,4
       //     i      for solving this i, you need (i-1 to 0)*(i+1 to N)
       // so we maintin two array prefixMult and suffixMult

       int n=nums.length; 
       int[] prefixMult = new int[n];
       int[] suffixMult = new int[n];

       // now storing all multiplication in for i -> (i-1 to 0) 
       prefixMult[0]=1; // at index 0, the previous value is 1;
       for(int i=1;i<n;i++){
            prefixMult[i]=prefixMult[i-1]*nums[i-1];
       }

       suffixMult[n-1]=1; // at index 0, the previous value is 1;
       for(int i=n-2;i>=0;i--){
            suffixMult[i]=suffixMult[i+1]*nums[i+1];
       }

       // now calculate the anser
       int[] ans = new int[n];
       for(int i=0;i<n;i++){
            ans[i]=prefixMult[i]*suffixMult[i];
       }

       return ans;
        
    }
}