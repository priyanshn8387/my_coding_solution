class Solution {

    public boolean validation(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;

        if (root.val <= minValue || root.val >= maxValue)
            return false;

        return validation(root.left, minValue, root.val) &&
               validation(root.right, root.val, maxValue);
    }

    public boolean isValidBST(TreeNode root) {
        return validation(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
