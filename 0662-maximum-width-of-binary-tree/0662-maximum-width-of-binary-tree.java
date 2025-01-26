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
    public int widthOfBinaryTree(TreeNode root) {
        // Deque<TreeNode,Integer> dq = new ArrayDeque<>();
        // int idx =0
        // dq.add(Pair<>(root,idx));

        // while(!dq.isEmpty()){

        //     Deque<TreeNode,Integer> dq = dq.poll();
        // }

                if (root == null) return 0;

        Deque<Pair<TreeNode, Long>> deque = new ArrayDeque<>();
        deque.offer(new Pair<>(root, 0L)); // Start with the root at index 0
        int maxWidth = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            long firstIndex = deque.peekFirst().getValue(); // Index of the first node in the level
            long lastIndex = deque.peekLast().getValue();  // Index of the last node in the level

            // Calculate the width of the current level
            maxWidth = (int) Math.max(maxWidth, lastIndex - firstIndex + 1);

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> current = deque.poll(); // Remove the first element
                TreeNode currentNode = current.getKey();
                long currentIndex = current.getValue();

                // Add left child with its calculated index
                if (currentNode.left != null) {
                    deque.offer(new Pair<>(currentNode.left, 2 * currentIndex + 1));
                }

                // Add right child with its calculated index
                if (currentNode.right != null) {
                    deque.offer(new Pair<>(currentNode.right, 2 * currentIndex + 2));
                }
            }
        }

        return maxWidth;
    }
}