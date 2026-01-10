class Solution {
    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();

        String s1= strs[0];
        String s2= strs[strs.length-1];
        int index=0;

        while(index<s1.length() && index<s2.length()){
            if(s1.charAt(index)!=s2.charAt(index)){
                break;
            }else{
                sb.append(s1.charAt(index));
            }
            index++;
        }

        return sb.toString();
        
    }
}