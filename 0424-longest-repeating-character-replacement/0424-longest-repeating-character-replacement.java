class Solution {
    public int characterReplacement(String s, int k) {

        if(s.length()<k) return 0;

        Map<Character,Integer> freqMap = new HashMap<>();

        int left=0;
        int right =0;
        int maxFreq = 0;
        int len =0;
        int maxLen = 0;


        while(right<s.length()){
            char incoming = s.charAt(right);
            freqMap.put(incoming,freqMap.getOrDefault(incoming,0)+1);

            maxFreq = Math.max(maxFreq,freqMap.get(incoming));
            len = right-left+1;

            if(len-maxFreq>k){
                while(len-maxFreq>k){
                    char outgoing = s.charAt(left);
                    if(freqMap.get(outgoing)==1){
                        freqMap.remove(outgoing);
                    }else{
                        freqMap.put(outgoing,freqMap.getOrDefault(outgoing,0)-1);
                    }
                    // Updating maxFreq on shrinkning
                    maxFreq=0;
                    for(Map.Entry<Character,Integer> it : freqMap.entrySet()){
                        maxFreq=Math.max(maxFreq,it.getValue());
                    }
                    left++;
                    len = right-left+1; // updating the len
                }
            }

            maxLen = Math.max(maxLen,right-left+1);

            right++;
        }

        return maxLen;

        
    }
}