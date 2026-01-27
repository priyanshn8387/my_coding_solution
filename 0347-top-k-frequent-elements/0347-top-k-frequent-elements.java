class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());

        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){

            pq.offer(entry);
            if(pq.size()>k) pq.poll();
        }

        int[] res = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            res[i++]=pq.poll().getKey();
           
        }

        return res;





    }
}