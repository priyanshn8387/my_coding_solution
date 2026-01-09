class Solution {

    public long findHours(int[] piles, int hours){
        long totalHours=0;
        for(int i=0;i<piles.length;i++){
            totalHours+=(int)Math.ceil((double)piles[i]/hours);
        }
        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int low =1;
        int high = Arrays.stream(piles).max().getAsInt();
        int res = high;

        while(low<=high){
            int mid = low+(high-low)/2;

            long totalHours=findHours(piles,mid);
            if(totalHours<=h){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return res;
        
    }
}