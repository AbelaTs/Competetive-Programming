// Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null){
            if(p.val != q.val){
                return false;
            }else{
                boolean left = isSameTree(p.left,q.left);
                boolean right = isSameTree(p.right,q.right);

                if(left == true && right == true){
                    return true;
                }
                return false;
            }
        }else if(p != null && q == null){
            return false;
        }else if(p == null && q != null){
            return false;
        }
        return true;
    }
}