class Solution {
    public int totalFruit(int[] fruits) {
        // similart to maximum length of subarray with equals to k window.
        int k=2;
        // if(fruits.length<k) return 0;
    

        int left=0;
        int right=0;
        int len =0;
        Map<Integer,Integer> freqMap = new HashMap<>();

        while(right<fruits.length){
            int incoming = fruits[right];
            freqMap.put(incoming,freqMap.getOrDefault(incoming,0)+1);

            if(freqMap.size()>k){
                while(freqMap.size()>k){
                    int outgoing = fruits[left];
                    if(freqMap.get(outgoing)==1){
                        freqMap.remove(outgoing);
                    }else{
                       freqMap.put(outgoing,freqMap.getOrDefault(outgoing,0)-1); 
                    }
                    left++;
                }
            }

            len = Math.max(len,right-left+1);
            right++;
        }

        return len;
    }
}