class Solution {
    public void sortColors(int[] nums) {

       // if(nums.length==null || nums.length<3) return -1;

        int low=0;
        int mid=0;
        int high=nums.length-1;

        while(mid<=high){
            if(nums[mid]==2){
                swap(nums,mid,high);
               // mid++; // kyuki yaha kuch bhi aa skta h 0/1/2, isliye check krna pdega mid ko.
                high--;

            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums,mid,low);
                mid++; // mid pein hmesh 1 aayesga aur vhi humey chahiye, isliye skip kr diya travesding mein
                low++; 
            }

        }
        
    }

    public void swap(int[] nums, int i, int j){
        int temp= nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }
}