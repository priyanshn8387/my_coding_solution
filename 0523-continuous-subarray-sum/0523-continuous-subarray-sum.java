class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer,Integer> prefixMap = new HashMap<>();
        prefixMap.put(0,-1);

        // replace sum with sum%k, coz it should be multiple of k

        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            if(prefixMap.containsKey(sum%k)){ // sum-k ->sum%k-k%k->sum%k-0->sum%k
                int subArrayStartIndex = prefixMap.get(sum%k)+1;
                int subArrayEndIndex = i;
                int len = subArrayEndIndex - subArrayStartIndex +1;

                if(len>=2){
                    return true;
                }

            }

            if(!prefixMap.containsKey(sum%k)) // coz we need longest length
                prefixMap.put(sum%k,i);
        }

        return false;

        
    }
}