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
    public TreeNode invertTree(TreeNode root) {

       if(root==null) return root;

       Queue<TreeNode> q = new LinkedList<>();

       q.offer(root);

       while(!q.isEmpty()){

        int size = q.size();

        TreeNode curr = q.poll();
        // swap links
        TreeNode temp = curr.left;
        curr.left=curr.right;
        curr.right=temp;

        if(curr.left!=null) q.add(curr.left);
        if(curr.right!=null) q.add(curr.right);


       }

       return root;
        
    }
}