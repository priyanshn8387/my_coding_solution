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
    public int maxLevelSum(TreeNode root) {
       
        if(root==null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxi = Integer.MIN_VALUE;
        int level = 1;
        int maxLevel = -1;

        while (!queue.isEmpty()) {
            
            int levelSize = queue.size();
            int sum=0;

            // Traverse the nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                // Get the first node in the queue
                TreeNode node = queue.poll();
                sum+=node.val;

                // Add the node's children to the queue for the next level
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if(maxi<sum){
                maxi=sum;
                maxLevel = level;
            }

            level++;
           
        }
    
    return maxLevel;
    }
}