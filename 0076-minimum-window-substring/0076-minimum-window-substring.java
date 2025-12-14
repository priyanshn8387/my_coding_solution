class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character,Integer> freqMap = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }
        int uniqueCharacterCount = freqMap.size();

        int left =0;
        int right=0;
        int len = Integer.MAX_VALUE;
        int startIndex = 0;

        while(right<s.length()){
            char incoming = s.charAt(right); //expansion
            if(freqMap.containsKey(incoming)){
                // if(freqMap.get(incoming)==1){
                //     freqMap.remove(incoming); // No need to remove as we are making it value -1,0,1
                //     uniqueCharacterCount--;
                // }else{
                //     freqMap.put(incoming,freqMap.getOrDefault(incoming,0)-1);
                // }

                freqMap.put(incoming,freqMap.getOrDefault(incoming,0)-1);
                if(freqMap.get(incoming)==0) uniqueCharacterCount--;
               
            }

            if(uniqueCharacterCount==0){
                while(uniqueCharacterCount==0){
                    char outgoing = s.charAt(left);
                   // len = Math.min(len,rigth-left+1); // we need maker for left index 
                    if(len>=right-left+1){
                        len = right-left+1;
                        startIndex = left;
                    }
                    if(freqMap.containsKey(outgoing)){
                        freqMap.put(outgoing, freqMap.getOrDefault(outgoing,0)+1);
                        if(freqMap.get(outgoing)==1) uniqueCharacterCount++;
                    }
                    

                    left++;
                }
            }

            right++;
        }

        if(len==Integer.MAX_VALUE) return "";
        else return s.substring(startIndex,startIndex+len);
    }
}