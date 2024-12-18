class Solution {
    public int maxVowels(String s, int k) {

       // Queue<Character> qu = new LinkedList<>(); // not needed queue
        int maxVowelCount = Integer.MIN_VALUE;
       int  vowelCount = 0;

        for(int i=0;i<k;i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
               // qu.offer(ch);
               vowelCount++;
            }
        }

         maxVowelCount = Math.max(maxVowelCount,vowelCount);

        for(int i=k;i<s.length();i++){
            char incoming = s.charAt(i);
            if(incoming == 'a' || incoming == 'e' || incoming == 'i' || incoming == 'o' ||  incoming == 'u'){
                //qu.offer(incoming);
                vowelCount++;
            }

            char outgoing = s.charAt(i-k);
            if(outgoing == 'a' || outgoing == 'e' || outgoing == 'i' || outgoing == 'o' ||  outgoing == 'u'){
                // if(!qu.isEmpty()){
                //     qu.poll();
                // } 
                vowelCount--;
            }

            maxVowelCount = Math.max(maxVowelCount,vowelCount);

        }

        if(maxVowelCount == Integer.MAX_VALUE) return 0;
        else return maxVowelCount;
        
    }
}