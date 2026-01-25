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

    public int Solve(TreeNode root) {
        if (root == null)
            return 0;

        int l = Solve(root.left);
        int r = Solve(root.right);

        int temp = Math.max(root.val + Math.max(l, r), root.val);
        int ans = Math.max(temp, l + r + root.val);
        res = Math.max(res, ans);

        return temp;
    }
    public int maxPathSum(TreeNode root) {
        
        Solve(root);
        return res;

    }
}