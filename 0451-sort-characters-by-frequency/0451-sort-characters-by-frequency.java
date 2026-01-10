class Solution {
    public String frequencySort(String s) {

        Map<Character,Integer> freq = new HashMap<>();

        for(int i=0;i<s.length();i++){
            freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)+1);
        }

    List<Map.Entry<Character,Integer>> array= new ArrayList<>(freq.entrySet());

        Collections.sort(array,(a,b)->b.getValue()-a.getValue());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<array.size();i++){
            char key = array.get(i).getKey();
            int val = array.get(i).getValue();
            while(val>0){
                sb.append(key);
                val--;
            }
        }

        return sb.toString();
        
    }
}