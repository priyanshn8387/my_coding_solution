class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        Map<Integer,Integer> integerMap = new HashMap<>();

        int left=0;
        int right=0;
        int maxLen = Integer.MIN_VALUE;

        while(right<nums.length){
            int number = nums[right]; // expansion phase
            integerMap.put(number,integerMap.getOrDefault(number,0)+1);

            // shrink phase
            if(integerMap.get(number)>k){
                
                while(integerMap.get(number)>k){
                    int leftNumber = nums[left];
                    if(integerMap.get(leftNumber) == 0 ){
                        integerMap.remove(leftNumber);
                    }else{
                        integerMap.put(leftNumber,integerMap.getOrDefault(leftNumber,0)-1);
                    }

                    left++;
                    
                }
            }

            maxLen= Math.max(maxLen,right-left+1);


            right++;

        }

        return maxLen;
        
    }
}