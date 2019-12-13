
// Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class Solution {
    TreeNode previous;
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 != null && t2 != null){
            previous = t1;
            if(t1 != null && t2 != null){
                int val1 = t1.val;
                int val2 = t1.val;
                 t1.val = t1.val + t2.val;
                 t2.val = val1 + val2;
                //Calling function for each side recursively
                t1.left = mergeTrees(t1.left,t2.left);
                t1.right = mergeTrees(t1.right,t2.right);
            }
         return t1;       
        }else if(t1!=null && t2 == null){
            return t1;
        }else{
            return t2;
        }
    }
    
}