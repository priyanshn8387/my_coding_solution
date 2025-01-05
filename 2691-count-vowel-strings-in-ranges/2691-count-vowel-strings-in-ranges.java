class Solution {

    public boolean isVowel(String s){

        int start =0;
        int end = s.length()-1;

        if((s.charAt(start) == 'a' || s.charAt(start) == 'e' || s.charAt(start) == 'i' ||
        s.charAt(start) == 'o' || s.charAt(start) == 'u') &&
        (s.charAt(end) == 'a' || s.charAt(end) == 'e' || s.charAt(end) == 'i' ||
        s.charAt(end) == 'o' || s.charAt(end) == 'u')){
            return true;
        }

        return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {

        int n = words.length;
        int[] checkVowel= new int[n];

        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(isVowel(word)){
                checkVowel[i]=1;
            }
        }

        // creating prefix sum for checkvowel array
        for(int i=1;i<n;i++){
            checkVowel[i]=checkVowel[i-1]+checkVowel[i];
        }

        int [] ans = new int[queries.length];
        int i_ = 0;
        for(int[] query : queries){
            int i= query[0];
            int j= query[1];

            if(i==0){
                ans[i_++]= checkVowel[j];
            }else{
                ans[i_++]= checkVowel[j]-checkVowel[i-1];
            }
        }

        return ans;
        
    }
}