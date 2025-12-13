class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        Map<Integer,Integer> freqMap = new HashMap<>();
        freqMap.put(0,1);

        int sum=0;
        int res =0;
        int rem =0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            rem = sum%k;
            if(rem<0) rem = rem+k;

            if(freqMap.containsKey(rem)){
                res+=freqMap.get(rem);
            }


            freqMap.put(rem,freqMap.getOrDefault(rem,0)+1);
        }

        return res;
        
    }
}