class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> ans = new HashMap<>();

        for(String word : strs){
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);

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