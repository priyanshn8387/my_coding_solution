class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
         if (firstList.length < 1 || secondList.length < 1) {
            return new int[0][];
        }

        int i=0,j=0;

        List<int[]> result = new ArrayList<>();

        while(i<firstList.length && j<secondList.length){

            int x=Math.max(firstList[i][0],secondList[j][0]);
            int y = Math.min(firstList[i][1],secondList[j][1]);

           // result.add(new int[]{x,y}); // in case of (8,12) && (13,23) this still gives answer, but this is non overlapping

            if (x <= y) { // in the output you can see always x<=y 
                result.add(new int[]{x, y});
            }

            // Move the pointer for the interval that ends earlier
            if(firstList[i][1]<secondList[j][1]) i++;
            else j++;


        }
        // Convert list to array and return
        return result.toArray(new int[result.size()][]);
    }
}