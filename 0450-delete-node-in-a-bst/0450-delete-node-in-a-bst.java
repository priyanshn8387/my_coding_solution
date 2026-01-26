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

    public TreeNode findMaxFromLeft(TreeNode root){
        while(root.right!=null){
            root=root.right;
        }

        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null) return root;

        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else{
            // 1. if this is leaf node
            if(root.left== null && root.right==null){
                return null;
            }

            //2. if this has 1 child
            if(root.left==null || root.right==null){
                if(root.left==null) return root.right;
                if(root.right==null) return root.left;
            }

            // 3. if it has two child
            
            TreeNode leftMax=findMaxFromLeft(root.left);
            root.val=leftMax.val;
            // now delete leftMax.val
            root.left=deleteNode(root.left,leftMax.val);


        }

        return root;


    }
}