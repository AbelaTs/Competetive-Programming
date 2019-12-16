
// Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
}
 
class InsertBST {
    static boolean inserted = false;
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root != null){
            if(val > root.val){
                if(root.right == null){
                    if(!inserted){
                        root.right = new TreeNode(val); 
                        inserted = true;
                        
                    }
                }
              
            }else if(val < root.val){
                  if(root.left == null){
                    if(!inserted){
                        root.left = new TreeNode(val); 
                        inserted = true;
                       
                    }
                }
               
            }
            
            if(val > root.val){
                 TreeNode right_root = insertIntoBST(root.right,val);
                 TreeNode left_root = insertIntoBST(root.left,val);
                
            }else if(val < root.val){
                 TreeNode left_root = insertIntoBST(root.left,val);
                 TreeNode right_root = insertIntoBST(root.right,val);
                    
            }
           
        }else{
            return new TreeNode(val);
        }
        
        return root;
       
        
        
    }
    

}