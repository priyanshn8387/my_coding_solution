class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        // edge cases 
        if(s2.length()<s1.length()) return false;
        int [] arr1 = new int[26];
        int [] arr2 = new int[26];

        int k = s1.length();
        for(int i=0;i<k;i++){
            arr1[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }
        //if(arr1.equals(arr2)) return true;// wrong syntax
        if(Arrays.equals(arr1,arr2)) return true;

        for(int i=k;i<s2.length();i++){
            char incoming = s2.charAt(i);
            char outgoing = s2.charAt(i-k);

            arr2[incoming-'a']++;
            arr2[outgoing-'a']--;

            if(Arrays.equals(arr1,arr2)) return true;
        }

        return false;
    }
}