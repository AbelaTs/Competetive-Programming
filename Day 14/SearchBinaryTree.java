//https://leetcode.com/problems/search-in-a-binary-search-tree/
//Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
class SearchBinaryTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }else{
                if(root.val == val){
                    return root;
                }
                root.left = searchBST(root.left,val);
                root.right = searchBST(root.right,val);
                
            
            if(root.left != null){
                return root.left;
            }
            return root.right;
        }
    }
}