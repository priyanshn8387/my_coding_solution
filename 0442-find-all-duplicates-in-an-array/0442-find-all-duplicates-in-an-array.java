class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]);

            if(nums[index-1]<0){
                res.add(Math.abs(nums[i]));
            }else{
                nums[index-1]=-nums[index-1];
            }
        }

        return res;
        
    }
}