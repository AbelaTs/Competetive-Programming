//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// Definition for a binary tree node.
class TreeNode {
     int val;
      TreeNode left;
    TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
             
    if(root == null){
        return null;
    }
      TreeNode left_root = null;
      TreeNode right_root = null;
        if(root.val == p.val || root.val == q.val){
                return root;  
        }else{
            if(root.left != null){
                left_root = lowestCommonAncestor(root.left,p,q);
            }
            if(root.right != null){
                right_root = lowestCommonAncestor(root.right,p,q);
            }
            
             if(left_root != null && right_root != null){
                return root;
            }else if(left_root != null && right_root == null){
                return left_root;
            }else if(right_root != null && left_root == null){
                return right_root;
            }else{
                return null;
            }
        }
        
    }
}