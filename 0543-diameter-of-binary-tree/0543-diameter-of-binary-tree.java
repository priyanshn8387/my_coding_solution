/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = Integer.MIN_VALUE;
    public int diameter(TreeNode root){
        if(root==null) return 0;

        int lh = diameter(root.left);
        int rh = diameter(root.right);

        int temp = Math.max(lh,rh)+1;
        int ans = Math.max(temp,lh+rh+1);
        res = Math.max(res,ans);

        return temp;
    }
    public int diameterOfBinaryTree(TreeNode root) {

        diameter(root);
        return res-1;
        
    }
}