class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
       
        int [] arr1 = new int[26];
        int [] arr2 = new int[26];

        List<Integer> res = new ArrayList<>();

        if(p.length()>s.length()) return res;

        int k = p.length();
        for(int i=0;i<k;i++){
            arr1[p.charAt(i)-'a']++;
            arr2[s.charAt(i)-'a']++;
        }
        //if(arr1.equals(arr2)) return true;// wrong syntax
        if(Arrays.equals(arr1,arr2)) {
            res.add(0);
        }
        for(int i=k;i<s.length();i++){
            char incoming = s.charAt(i);
            char outgoing = s.charAt(i-k);

            arr2[incoming-'a']++;
            arr2[outgoing-'a']--;

            if(Arrays.equals(arr1,arr2)) {
                res.add(i-k+1);
            }
        }

        return res;
    }
}