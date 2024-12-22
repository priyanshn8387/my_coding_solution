class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        // since it is already sorted

        List<List<Integer>> allIntervals = new ArrayList<>();
        //add first intervals
        allIntervals.add(Arrays.asList(newInterval[0],newInterval[1]));
        // add remaining element as well
        for(int i=0;i<intervals.length;i++){
            allIntervals.add(Arrays.asList(intervals[i][0],intervals[i][1]));
        }


        // now sort, coz new element added
        Collections.sort(allIntervals,(a,b)->a.get(0)-b.get(0));

        // adding firstElement in new list
        List<List<Integer>> result = new ArrayList<>();
        result.add(allIntervals.get(0));


        for(int i=1;i<allIntervals.size();i++){

            List<Integer> prevList = result.get(result.size()-1);
            int prevStart = prevList.get(0);
            int prevEnd = prevList.get(1);

            if(prevEnd>=allIntervals.get(i).get(0)){
                prevList.set(1,Math.max(prevEnd,allIntervals.get(i).get(1)));
            }else{
            result.add(Arrays.asList(allIntervals.get(i).get(0),allIntervals.get(i).get(1)));
            }
        }

          // Step 5: Convert List<List<Integer>> to a 2D array
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i).get(0);
            ans[i][1] = result.get(i).get(1);
        }

        return ans;



    }
}