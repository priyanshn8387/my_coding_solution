//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
     
      Solution obj = new Solution();
      boolean ans = obj.checkSubsequenceSum(n,a,k);
      System.out.println(ans?"Yes":"No");
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
public static boolean recur(int[] arr,int index,int sum,int[][] dp){
    
    //base case
    
    if(sum==0) return true;
    if(index==0) return arr[index]==sum;
    
    if(dp[index][sum]!=-1) {
        
        return dp[index][sum] == 1;
        
    };
    
    
    boolean pick = false;
    if(arr[index]<=sum){
        pick = recur(arr,index-1,sum-arr[index],dp);
    }
    
    boolean notPick = recur(arr,index-1,sum,dp);
    
    // store the current state in dp
    dp[index][sum] = (pick || notPick) ? 1 : 0 ; //(1 for true, 0 for false).
    
    // return the state, in boolean value
    return dp[index][sum]==1;
    
    
}    
  public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
    // code here
    int index=arr.length-1;
    int[][] dp = new int[arr.length][K + 1];
    for(int[] row : dp) Arrays.fill(row,-1);
    
    
    return recur(arr,index,K,dp);

  }
}
     