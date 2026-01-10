class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length()!=t.length()) return false;

        Map<Character,Character> freqMap = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(freqMap.containsKey(s.charAt(i))){
                if(!freqMap.get(s.charAt(i)).equals(t.charAt(i))){
                    return false;
                }
            }
            else{
                
                if(freqMap.containsValue(t.charAt(i))){
                return false;}
            }
            freqMap.put(s.charAt(i),t.charAt(i));
        }

        return true;
        
    }
}