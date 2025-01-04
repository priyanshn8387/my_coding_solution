class Solution {

    List<List<String>> result = new ArrayList<>();


    public void recur(String s, int index, List<String> curr){

        if(index==s.length()){
           // result.add(curr); // cant add directly, java collection, make a copy 
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index;i<s.length();i++){
            String partition = s.substring(index,i+1);
            if(isPalindrome(partition)){
                curr.add(partition);
                recur(s,i+1,curr); 
                curr.remove(curr.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int start=0;
        int end = s.length()-1;

        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
    public List<List<String>> partition(String s) {
        List<String> curr = new ArrayList<>();
        recur(s,0,curr);
        return result;
    }
}