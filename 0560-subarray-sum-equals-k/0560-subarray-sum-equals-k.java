class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);

        int sum=0;
        int totalCountSubArray = 0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            
            if(prefixSum.containsKey(sum-k)){
                totalCountSubArray+=prefixSum.get(sum-k);
            }

            prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);
        }

        return totalCountSubArray;
        
    }
}