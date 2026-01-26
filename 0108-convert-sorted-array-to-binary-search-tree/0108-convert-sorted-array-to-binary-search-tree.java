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
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length==0) return null;
        int low =0;
        int high = nums.length-1;
        int mid = (low+high)/2;

        int [] left = new int[mid];
        int [] right = new int[high-mid];

        for(int i=0;i<mid;i++){
            left[i]=nums[i];
        }
        int j=0;
        for(int i=mid+1;i<nums.length;i++){
            right[j++]=nums[i];
        }
       

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(left);
        root.right =sortedArrayToBST(right);

        return root;
        
    }
}