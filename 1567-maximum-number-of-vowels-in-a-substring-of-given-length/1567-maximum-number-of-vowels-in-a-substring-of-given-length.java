class Solution {
    public int maxVowels(String s, int k) {

        Queue<Character> qu = new LinkedList<>();
        int maxVowelCount = Integer.MIN_VALUE;

        for(int i=0;i<k;i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                qu.offer(ch);
            }
        }

        maxVowelCount = Math.max(maxVowelCount,qu.size());

        for(int i=k;i<s.length();i++){
            char incoming = s.charAt(i);
            if(incoming == 'a' || incoming == 'e' || incoming == 'i' || incoming == 'o' ||  incoming == 'u'){
                qu.offer(incoming);
            }

            char outgoing = s.charAt(i-k);
            if(outgoing == 'a' || outgoing == 'e' || outgoing == 'i' || outgoing == 'o' ||  outgoing == 'u'){
                if(!qu.isEmpty()){
                    qu.poll();
                } 
            }

            maxVowelCount = Math.max(maxVowelCount,qu.size());

        }

        if(maxVowelCount == Integer.MAX_VALUE) return 0;
        else return maxVowelCount;
        
    }
}