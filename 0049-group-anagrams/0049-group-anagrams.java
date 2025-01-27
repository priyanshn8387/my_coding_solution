class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> ans = new HashMap<>();

        for(String word : strs){

            // char[] ch = word.toCharArray();
            // Arrays.sort(ch);
            // String sorted = new String(ch); // make it optimised

            int[] charFreq = new int[26];
            for(char ch : word.toCharArray()){
                charFreq[ch-'a']++;
            }

            // retrieve from charFreq with adding identifaction of space with "#"
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){ 
                if(charFreq[i]!=0){
                    int frequencyElem =charFreq[i];
                    while(frequencyElem>0){
                        sb.append((char)97+i);
                        frequencyElem--;
                    }
                    
                }
            }

            String sorted = sb.toString();

            if(!ans.containsKey(sorted)){
                ans.put(sorted,new ArrayList<>());
            }
            ans.get(sorted).add(word);
        }

        List<List<String>> res = new ArrayList<>();

        for(Map.Entry<String,List<String>> entry : ans.entrySet()){
            res.add(entry.getValue());
        }

        return res;
        
    }
}