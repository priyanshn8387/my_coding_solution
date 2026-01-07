class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        Map<Integer,Integer> freqMap = new HashMap<>();
        freqMap.put(0,1);
        int totalSum=0;
        int sum=0;
    

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            if(freqMap.containsKey(sum-goal)){
                totalSum+=freqMap.get(sum-goal);
            }

            freqMap.put(sum,freqMap.getOrDefault(sum,0)+1);


        }

        return totalSum;
        
    }
}