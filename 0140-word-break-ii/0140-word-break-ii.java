class Solution {

    List<String> output = new ArrayList<>();

    public void recur(String s, List<String> wordDict, int index, StringBuilder sb) {
      
        if (index == s.length()) {
            output.add(sb.toString().trim());
            return;
        }


        // Try every possible partition starting from the current index
        int lenBeforeAddingSb = sb.length(); // Save current length of sb
        for (int i = index; i < s.length(); i++) {
            String partition = s.substring(index, i + 1);
            if (wordDict.contains(partition)) {
                sb.append(partition).append(" ");
                recur(s, wordDict, i + 1,sb); // explore possibilities
                sb.setLength(lenBeforeAddingSb); // backtrack
            }
        }


    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        int index = 0;
       // Boolean[] dp = new Boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        recur(s, wordDict, index,sb);

        return output;
    }
}
