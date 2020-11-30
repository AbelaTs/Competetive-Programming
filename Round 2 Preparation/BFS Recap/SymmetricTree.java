//https://leetcode.com/problems/symmetric-tree/
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return checkSymmetry(root,root);
        
    }
    public boolean checkSymmetry(TreeNode leftRoot, TreeNode rightRoot){
        if(leftRoot == null && rightRoot == null){
            return true;
        }else if(leftRoot!= null && rightRoot != null){
            return leftRoot.val == rightRoot.val && checkSymmetry(leftRoot.left,rightRoot.right) && checkSymmetry(rightRoot.left,leftRoot.right);
        }
        return false;
    }
}
