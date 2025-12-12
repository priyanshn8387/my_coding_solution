class Solution {
    public int findMaxLength(int[] nums) {
        
        if(nums==null || nums.length==0) return 0;

        Map<Integer,Integer> prefixMap = new HashMap<>();
        prefixMap.put(0,-1);

        int prefixSum = 0;
        int k =0; // figured out from question
        int maxi =0;

        for(int i=0;i<nums.length;i++){ // Transforming the array to make it 0->-1
            if(nums[i]==0) nums[i]=-1;
        }

        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];

            if (prefixMap.containsKey(prefixSum - k)) {
                
                // 1. Get the index *before* the subarray starts
                int previousIndex = prefixMap.get(prefixSum - k); 
                
                // 2. Define the subarray boundaries explicitly:
                int subArrayStartIndex = previousIndex + 1;
                int subArrayEndIndex = i;
                
                // 3. Calculate length using the standard formula (End - Start + 1)
                int len = subArrayEndIndex - subArrayStartIndex + 1;
                
                maxi = Math.max(maxi, len);
            }
            
            // CRUCIAL LOGIC for LONGEST Subarray: 
            // Only store the sum if it's the first time seeing it, 
            // ensuring we use the earliest index for maximum length calculation.
            if (!prefixMap.containsKey(prefixSum)) {
                prefixMap.put(prefixSum, i);
            }


        }

        return maxi;

    }
}