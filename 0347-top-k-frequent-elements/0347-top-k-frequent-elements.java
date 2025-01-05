class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // it can also be solved with sorting on the basis of frequency 
        // this that will take nlogn
        // using min heap it can be solve in n*logk or k*logk

        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
        }

        // now create min heap with map with frequency in ascending order
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()-b.getValue());


        // now add only k element

        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            pq.offer(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] res = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            res[i++]=pq.poll().getKey();
           
        }

        return res;

        
    }
}