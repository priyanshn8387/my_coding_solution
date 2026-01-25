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

    int maxSum = Integer.MIN_VALUE;

    public int getHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight  = Math.max(0,getHeight(node.left));
        int rightHeight = Math.max(0,getHeight(node.right));

        // Height to be passed to parent
        int currentHeight = Math.max(leftHeight, rightHeight)+node.val;

        // Diameter passing through current node (in nodes)
        int diameterThroughNode = leftHeight + rightHeight + node.val;

        // Update global maximum diameter
        maxSum = Math.max(maxSum, diameterThroughNode);

        return currentHeight;
    }
    public int maxPathSum(TreeNode root) {
        
        getHeight(root);

        return maxSum;

    }
}