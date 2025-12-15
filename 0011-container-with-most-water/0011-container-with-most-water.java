class Solution {
    public int maxArea(int[] arr) {
        
        int left =0;
        int right= arr.length-1;
        int maxArea = Integer.MIN_VALUE;

        while(left<right){
            int height = Math.min(arr[left],arr[right]);
            int width = right-left;

            maxArea = Math.max(maxArea,height*width);

            if(arr[right]>=arr[left]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;

    }
}