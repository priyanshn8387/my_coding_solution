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
    public List<Integer> rightSideView(TreeNode root) {

        
        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        if(root==null) return res;

        dq.offer(root);

        while(!dq.isEmpty()){
            int size = dq.size();

            int leftElement = dq.peekLast().val;
            res.add(leftElement);

            for (int i = 0; i < size; i++) {
                // Get the first node in the queue
                TreeNode node = dq.poll();

                if (node.left != null) {
                    dq.offer(node.left);
                }
                if (node.right != null) {
                    dq.offer(node.right);
                }
            }
        }

        return res;
    }
}