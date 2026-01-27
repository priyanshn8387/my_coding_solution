class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Step 1: frequency count
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Step 2: max heap
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0) maxHeap.offer(f);
        }

        int time = 0;

        // Step 3: process cycles
        while (!maxHeap.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            while (cycle > 0 && !maxHeap.isEmpty()) {
                int curr = maxHeap.poll();
                if (curr > 1) temp.add(curr - 1);
                time++;
                cycle--;
            }

            for (int t : temp) {
                maxHeap.offer(t);
            }

            if (maxHeap.isEmpty()) break;

            time += cycle; // idle slots
        }

        return time;
    }
}
