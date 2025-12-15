class Solution {
    public List<List<Integer>> threeSum(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> unique = new HashSet<>();

        if(arr == null || arr.length <3) return res;

        Arrays.sort(arr);
        int len = arr.length;

        for(int i=0;i<len-2;i++){

            int num1 = arr[i];

            // two pointer approach

            int left =  i+1;
            int right = len-1;

            while(left<right){
                int num2 = arr[left];
                int num3 = arr[right];
                int sum = num1+num2+num3;

                if(sum==0){
                    unique.add(Arrays.asList(num1,num2,num3));
                    // finding more triplet
                    left++;
                    right--;
                }else if(sum>0){
                    right--;
                }else {
                    left++;
                }
            }
        }

        //return res.addAll(unique); 
        res.addAll(unique);
        return res;


        
    }
}