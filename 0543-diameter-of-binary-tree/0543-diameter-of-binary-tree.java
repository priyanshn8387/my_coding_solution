class Solution {

    // Stores the maximum diameter (in number of nodes)
    int maxDiameter = 0;

    // Returns height of the subtree rooted at current node
    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight  = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // Height to be passed to parent
        int currentHeight = Math.max(leftHeight, rightHeight) + 1;

        // Diameter passing through current node (in nodes)
        int diameterThroughNode = leftHeight + rightHeight + 1;

        // Update global maximum diameter
        maxDiameter = Math.max(maxDiameter, diameterThroughNode);

        return currentHeight;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);

        // Convert nodes count to edges count
        return maxDiameter - 1;
    }
}
