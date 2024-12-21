class Solution {
    public int[][] merge(int[][] intervals) {

        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        List<int[]> li = new ArrayList<>();

        li.add(intervals[0]); // adding first interval

        for(int i=1;i<intervals.length;i++){
            int start=intervals[i][0];
            int end =intervals[i][1];

            // Check for overlap with the last interval in the result
            // li.get(li.size()-1)[0] => 1
            // li.get(li.size()-1)[1] => 3
            if(li.get(li.size()-1)[1]>= start){
                li.get(li.size()-1)[1]=Math.max(li.get(li.size()-1)[1],end);
            }else{
                li.add(intervals[i]); // adding to back to list li
            }  
        }

        // Step 5: Convert result list to a 2D array
        return li.toArray(new int[li.size()][]);







        
    }
}