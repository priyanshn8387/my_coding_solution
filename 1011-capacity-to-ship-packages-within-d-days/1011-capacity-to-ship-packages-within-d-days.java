class Solution {

    public int calculateDays(int[] weights, int capacity){
        int load=0;
        int day=1;

        for(int i=0;i<weights.length;i++){
            if(load+weights[i]>capacity){
                day++;
                load=weights[i];
            }else{
                load+=weights[i];
            }
        }
       

        return day;
    }
    public int shipWithinDays(int[] weights, int days) {


        //int low = Arrays.stream(weights).max().getAsInt();
        int low=0;
        int high=0;
       // int high = Arrays.stream(weights).sum().getAsInt();//
         for (int i = 0; i < weights.length; i++) {
            low = Math.max(low, weights[i]); // at least max weight
            high += weights[i];              // at most sum of weights
        }
        int res = high;

        while(low<=high){
            int mid = low+(high-low)/2;
            int calcualatedDays=calculateDays(weights,mid);

            if(calcualatedDays<=days){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return res;
        
    }
}