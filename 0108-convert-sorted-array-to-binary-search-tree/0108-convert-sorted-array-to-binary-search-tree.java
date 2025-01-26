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

        //base condition
        int size = nums.length;

        if(size==0) return null;
        if(size==1) return new TreeNode(nums[0]);
        int mid = size/2;

        TreeNode root = new TreeNode(nums[mid]);
        int[] leftList = new int[mid];
        int[] rightList = new int[size-1-mid];
       

        for(int i=0;i<mid;i++){
            leftList[i]=nums[i];
        }
        int index=0;
        for(int i=mid+1;i<size;i++){
            rightList[index++]=nums[i];
        }
        root.left = sortedArrayToBST(leftList);
        root.right = sortedArrayToBST(rightList);

        return root;
        
    }
}