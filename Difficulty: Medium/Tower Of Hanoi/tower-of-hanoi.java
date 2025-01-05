//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // total testcases
        while (T-- > 0) {
            Solution obj = new Solution();
            int N;

            // taking input N
            N = sc.nextInt();

            // calling toh() method
            System.out.println(obj.towerOfHanoi(N, 1, 3, 2));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public int solve(int n, int from, int to, int aux){
        
        if(n==0) return 0;
        if(n==1) return 1;
        
        int x=solve(n-1,from,aux,to);
        int y=solve(n-1,aux,to,from);
        
        return x+y+1;
        
        
    }

    public int towerOfHanoi(int n, int from, int to, int aux) {
        // Your code here
        
        return solve(n,from,to,aux);
    }
}
