class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> st = new Stack<>();

        int n= temperatures.length;

        int[] res = new int[n]; // by defualt zero value

        for(int i=0;i<n;i++){

            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i] ){
                int index = st.peek();
                res[index]= i-index;
                st.pop();
            }

            st.add(i);
        }

        return res;




    }
}