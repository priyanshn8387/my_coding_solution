//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            System.out.println(solution.smallestSubWithSum(x, arr));

            T--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        
        int left=0;
        int right=0;
        int sum=0;
        int minLength = Integer.MAX_VALUE;
        
        while(right<arr.length){
            sum+=arr[right];
            
            if(sum>x){ // now we got one valid window, to find min length, we have to shrink
                minLength = Math.min(minLength,right-left+1);
                
                while(sum>x && left<right){
                    sum-=arr[left]; 
                    left++;
                    
                    if(sum>x){// sum got chnaged, so again have to check to find min len
                        minLength = Math.min(minLength,right-left+1);
                    }  
                }
                
            }
            
            right++;
        }
        
        return (minLength == Integer.MAX_VALUE ? 0 : minLength);
        
    }
}
