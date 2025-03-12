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
        
        Deque<Pair<TreeNode,Long>> dq = new ArrayDeque<>();

        dq.offer(new Pair<>(root,0L));
        long maxi = Integer.MIN_VALUE;


        while(!dq.isEmpty()){
            int size = dq.size();

            long firstIndex = dq.peekFirst().getValue();

            long lastIndex = dq.peekLast().getValue();

            maxi = Math.max(maxi,lastIndex-firstIndex+1);

            for(int i=0;i<size;i++){
                Pair<TreeNode,Long> current = dq.poll();
                TreeNode currentNode = current.getKey();
                Long index = current.getValue();

                if(currentNode.left!=null){
                    dq.offer(new Pair<>(currentNode.left,2*index+1));
                }

                if(currentNode.right!=null){
                    dq.offer(new Pair<>(currentNode.right,2*index+2));
                }

            }


        }


        return (int)maxi;


        
    }
}