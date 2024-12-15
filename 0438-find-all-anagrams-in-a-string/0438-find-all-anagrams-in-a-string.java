class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> txtMap = new HashMap<>();
        Map<Character, Integer> pattMap = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        // add corner case always, p cant be longer than s
        if(s.length()<p.length()) return results;

        int k = p.length();
        


        for (int i = 0; i < k; i++) {
            char txt = s.charAt(i);
            char patt = p.charAt(i);

            txtMap.put(txt,txtMap.getOrDefault(txt,0)+1);
            pattMap.put(patt,pattMap.getOrDefault(patt,0)+1);
           
        }

        if (txtMap.equals(pattMap)) {
            results.add(0);
        }

        for (int i = k; i < s.length(); i++) {

            char incoming = s.charAt(i);
            txtMap.put(incoming,txtMap.getOrDefault(incoming,0)+1);

            char outgoing = s.charAt(i - k);
            if (txtMap.get(outgoing) == 1) {
                txtMap.remove(outgoing);
            } else {
                txtMap.put(outgoing, txtMap.get(outgoing) - 1);
            }

            if (txtMap.equals(pattMap)) {
                results.add(i-k+1);
            }
        }

        return results;

    }
}