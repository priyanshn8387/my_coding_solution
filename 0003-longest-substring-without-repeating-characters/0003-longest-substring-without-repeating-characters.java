class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left =0;
        int right =0;
        Map<Character,Integer> freqMap = new HashMap<>();
        int maxLen = 0;


        while(right<s.length()){
            char ch = s.charAt(right); // expansion
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);

            if(freqMap.get(ch)>1){ // shrinking, coz we want unique character
                while(freqMap.get(ch)>1 && left<right){ // ensuring boundaries as well left<right
                    char outgoing = s.charAt(left);

                    if(freqMap.get(outgoing)==1){
                        freqMap.remove(outgoing);
                    }else{
                        freqMap.put(outgoing,freqMap.getOrDefault(outgoing,0)-1);
                    }

                    left++;
                }
            }

            maxLen = Math.max(maxLen,right-left+1);

            right++;


        }

        return maxLen;
        
    }
}