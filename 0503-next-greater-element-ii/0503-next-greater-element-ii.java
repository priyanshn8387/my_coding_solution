class Solution {
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int n= nums.length;

        int [] res = new int[n];
        Arrays.fill(res,-1);

        for(int i=0;i<2*nums.length-1;i++){
            int idx = i%n;

            while(!st.isEmpty() && nums[st.peek()]<nums[idx]){
                int index=st.pop();
                res[index]=nums[idx];
            }


            st.add(idx);
        }

        return res;
        
    }
}