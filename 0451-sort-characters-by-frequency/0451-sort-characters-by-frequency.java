class Solution {

    public String frequencySort(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        // now create max heap with map with frequency in descensing order
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
           
           // char key =pq.poll().getKey(); // this is wrong
           // int val = pq.poll().getValue(); // this is wrong, you are calling poll two times

            Map.Entry<Character,Integer> data = pq.poll();
            char key =data.getKey(); 
            int val = data.getValue();

            while(val>0){
                sb.append(key);
                val--;
            }

        }

        return sb.toString();
    }
}
