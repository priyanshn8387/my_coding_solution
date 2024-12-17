class Solution {
    public String minWindow(String s, String t) {

        Map<Character,Integer> freqMap = new HashMap<>();

        for(int i=0;i<t.length();i++){ // filling up the map
            char ch = t.charAt(i);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }

        // now, valid window will have all character present in string S.
        // like : BECODEBA
        // now remember the concept of ucc -> unique character count, which is size of map
        // initially the ucc = 3 , means charcter is not conusumed, if its : 0 then we can say
        // that it is consumed in valid window

        int uniqueCharacterCount = freqMap.size();
        int left = 0, right = 0; // or windowStart, windowEnd
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1 ; // to calculate the final substring : startIndex+minLength

        while(right<s.length()){
            char ch = s.charAt(right);
            if(freqMap.containsKey(ch)){ // expansion phase
                freqMap.put(ch,freqMap.get(ch)-1);
                
                if(freqMap.get(ch)==0){ // means we have consumed and that character are there 
                // in main string s
                    uniqueCharacterCount--;
                }
            }

            // now we got valid window, now we have to shrink to find min length
            // untile unless we got valid window we need to shrink
            // that means walid vindow is ucc = 0

            while(uniqueCharacterCount == 0){ // shrinking
                int substringLen = right-left+1;
                if(minLength>substringLen){ // finding min length
                    minLength=substringLen;
                    startIndex=left;
                }

                ch = s.charAt(left);
                if(freqMap.containsKey(ch)){ 
                    freqMap.put(ch,freqMap.get(ch)+1);
                    
                    if(freqMap.get(ch)>0){ // now again the map has value A->1 this means, A 
                    //             is 
                    //gone from main string s, so now ucc will incresee and again need to find 
                    // for 
                    //A in expnsion
                        uniqueCharacterCount++;
                    }
                }
                left++;
            }
            right++; //looking for next A in main string A, so expansion phase

        }

        if(minLength == Integer.MAX_VALUE) return "";
        else return s.substring(startIndex,startIndex+minLength);

        
    }
}