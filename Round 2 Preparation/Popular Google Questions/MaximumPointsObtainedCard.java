//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
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
        // if(root == null){
        //     return true;
        // }
        // return checkSymmetry(root,root);
        //Iterative
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(queue.size() != 0){
            TreeNode leftRoot = queue.remove();
            TreeNode rightRoot = queue.remove();
            if(leftRoot == null && rightRoot != null || leftRoot != null && rightRoot == null){
                return false;
            }else if(rightRoot != null && leftRoot != null &&leftRoot.val != rightRoot.val){
                return false;
            }else if(rightRoot != null && leftRoot != null){
                queue.add(leftRoot.left);
                queue.add(rightRoot.right);
                queue.add(leftRoot.right);
                queue.add(rightRoot.left);
            }
            
        }
        return true;
    }
    //recursive
    public boolean checkSymmetry(TreeNode leftRoot, TreeNode rightRoot){
        if(leftRoot == null && rightRoot == null){
            return true;
        }else if(leftRoot!= null && rightRoot != null){
            return leftRoot.val == rightRoot.val && checkSymmetry(leftRoot.left,rightRoot.right) && checkSymmetry(rightRoot.left,leftRoot.right);
        }
        return false;
    }
}