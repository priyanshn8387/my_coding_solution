class Solution {
    public int[] twoSum(int[] numbers, int target) {


        // Check edge cases 
        if(numbers == null || numbers.length<2) return new int[]{-1,-1};

        int left =0;
        int right = numbers.length-1;

        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum==target) return new int[]{left+1,right+1};
            else if(sum<target) left++;
            else right--;
        }
        
        // if no pair found
        return new int[]{-1,-1};  
    }
}