
// Definition for a binary tree node.
class TreeNode {
     int val;
      TreeNode left;
    TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
public class LowestCommonAncestor {
    TreeNode left_root;
    TreeNode right_root;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }else{
            if(root.val == p.val || root.val == q.val){
                left_root = lowestCommonAncestor(root.left,p,q);
                right_root = lowestCommonAncestor(root.right,p,q);
                if(left_root != null || right_root != null){
                    return root;
                }else{
                    return root; 
                }
               
            }else if(root.left != null && root.right != null){//If node has both right and left
                
                if(root.left.val == p.val && root.right.val == q.val || root.left.val == q.val && root.right.val == p.val){
                    return root;
                    
                }else{
                        
                    left_root = lowestCommonAncestor(root.left,p,q);
                    right_root = lowestCommonAncestor(root.right,p,q);
                }   
              
                  
            }else if(root.left != null && root.right == null){//If node has left but no right
                
                if(root.val == p.val || root.val == q.val){
                    left_root = lowestCommonAncestor(root.left,p,q);
                    if(left_root != null){
                        return left_root;
                    }else{
                        return null;
                    }
                }else{
                        
                    left_root = lowestCommonAncestor(root.left,p,q);
                    right_root = lowestCommonAncestor(root.right,p,q);
                } 
                
            }else if(root.right != null && root.left == null){//If node has right but no left
                
               if(root.val == p.val || root.val == q.val){
                    right_root = lowestCommonAncestor(root.right,p,q);
                    if(right_root != null){
                        return right_root;
                    }else{
                        return null;
                    }
                }else{
                        
                    left_root = lowestCommonAncestor(root.left,p,q);
                    right_root = lowestCommonAncestor(root.right,p,q);
                } 
            }
              //Returning the result
                if(left_root != null && right_root != null){
                    return root;
                }else if(left_root != null){
                     return left_root;
                }else if(right_root != null){
                     return right_root;
                }else{
                  return null;
              } 
        }
    }
}