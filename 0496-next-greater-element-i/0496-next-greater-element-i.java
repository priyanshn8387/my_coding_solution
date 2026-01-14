class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> st = new Stack<>();
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<nums2.length;i++){

            while(!st.isEmpty() && nums2[st.peek()]<nums2[i]){
                int index = st.pop();
                mp.put(nums2[index],nums2[i]);
            }
            st.add(i);
        }


        int [] res = new int[nums1.length];
        Arrays.fill(res,-1);
        for(int i=0;i<nums1.length;i++){
            if(mp.containsKey(nums1[i])){
                res[i]=mp.get(nums1[i]);
            }
        }

        return res;
    }
}