//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        int left=0;
        int right =0;
        int maxLength = -1;
        
        Map<Character,Integer> freqMap = new HashMap<>();
        
        while(right<s.length()){
            char ch = s.charAt(right);
            
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
            
            if(freqMap.size()==k){
                maxLength = Math.max(maxLength,right-left+1);
            }
            
            if(freqMap.size()>k){ // now shrinking phase
                
                while(freqMap.size()>k){
                    
                    ch = s.charAt(left);
                    
                    if(freqMap.get(ch)==1){
                        freqMap.remove(ch);
                    }else{
                       freqMap.put(ch,freqMap.getOrDefault(ch,0)-1); 
                    }
                    
                    left++;
                }
            }
            
            
            right++;
            
        }
        
        return maxLength;
    }
}