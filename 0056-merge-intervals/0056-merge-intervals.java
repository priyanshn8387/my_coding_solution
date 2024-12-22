class Solution {
    public int[][] merge(int[][] intervals) {

        
       // Step 1: Sort intervals based on start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: Use a list of lists to store merged intervals
        List<List<Integer>> mergedIntervals = new ArrayList<>();

        // Step 3: Add the first interval as a list
        mergedIntervals.add(Arrays.asList(intervals[0][0], intervals[0][1]));

        // Step 4: Iterate through intervals and merge overlapping ones
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Get the last interval in the merged list
            List<Integer> lastInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            int lastEnd = lastInterval.get(1);

            if (lastEnd >= start) {
                // Overlapping case: update the end of the last interval
                lastInterval.set(1, Math.max(lastEnd, end));
            } else {
                // Non-overlapping case: add a new interval
                mergedIntervals.add(Arrays.asList(start, end));
            }
        }

        // Step 5: Convert List<List<Integer>> to a 2D array
        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i][0] = mergedIntervals.get(i).get(0);
            result[i][1] = mergedIntervals.get(i).get(1);
        }

        return result;







        
    }
}