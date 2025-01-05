class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        Map<Integer,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);

        int sum=0;
        int totalCountSubArray = 0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int mod = sum%k;
            if(mod<0){
                mod = (mod+k)%k;
            }
            
            if(prefixSum.containsKey(mod)){
                totalCountSubArray+=prefixSum.get(mod);
            }

            prefixSum.put(mod,prefixSum.getOrDefault(mod,0)+1);
        }

        return totalCountSubArray;

        // IT IS FALING AT NEGATIVE NUMBER LIKE [-1,2,9]
        // TO FIX THIS WE NEED TO CONVERT THE NEGATIVE MODULO TO POSTIVE
        // Normalize remainder to avoid negative values
        // int MOD = SUM%K
        //   int remainder = (MOD + k) % k;
    }
}