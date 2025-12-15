class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        if(nums.length<k) return 0;
        Map<Integer,Integer> freqMap = new HashMap<>();
        long sum = 0;
        long maxSum = 0;

        for(int i=0;i<k;i++){
            sum+=nums[i];
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
        }

        if(freqMap.size()==k) maxSum = sum;


        for(int i=k;i<nums.length;i++){
            int incoming = nums[i];
            int outgoing = nums[i-k];

            // map sein nikalenegey and sum bhi
            if(freqMap.get(outgoing)==1){
                freqMap.remove(outgoing);
            }else{
                freqMap.put(outgoing,freqMap.getOrDefault(outgoing,0)-1);
            }
            sum-=outgoing;

            // map mein naya element add krenegy
            freqMap.put(incoming,freqMap.getOrDefault(incoming,0)+1);
            sum+=incoming;

            System.out.println(sum);

            if(freqMap.size()==k){
                maxSum=Math.max(maxSum,sum);
            }
        }

        return maxSum;

        
        
    }
}