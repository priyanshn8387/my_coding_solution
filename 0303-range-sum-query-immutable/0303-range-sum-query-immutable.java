class NumArray {

    List<Integer> prefixSum = new ArrayList<>();
    int sum=0;

    public NumArray(int[] nums) {

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            prefixSum.add(sum);
        }
    }
    
    public int sumRange(int left, int right) {
        if(left-1<0) return prefixSum.get(right);
        else return prefixSum.get(right)-prefixSum.get(left-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */