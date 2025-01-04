class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void recur(int[] nums,int index){

        // if(index==nums.length){
        //     res.add(nums); // issue : The nums array is added directly to res. Since nums is a reference type, any changes made to it later will also modify the entries in res.
        //     return;
        // }

        if(index==nums.length){
            List<Integer> tempNums = new ArrayList<>();
            for(int num : nums){
                tempNums.add(num);
            }
            res.add(tempNums);

            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(index,i,nums);
            recur(nums,index+1);
            swap(index,i,nums);
        }
    }

    public void swap(int i, int j, int[]nums){
        int c = nums[i];

        nums[i]=nums[j];
        nums[j]=c;
        
    }
    public List<List<Integer>> permute(int[] nums) {

        recur(nums,0);
        return res;

        

    }
}