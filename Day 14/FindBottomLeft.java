
// Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class FindBottomLeft {
    static int node_value;
    static int curr_row; 
    public int findBottomLeftValue(TreeNode root) {
        curr_row = -1;
        SearchForBottom(root,0);
        return node_value;
       
        
    }
 
   //Searches for the bottom node value
    public void SearchForBottom(TreeNode root, int row) {
        if (root == null){
            return;
        }
        //if the the current row level is level is lower than previous
        if (row > curr_row) {
            curr_row = row;
            node_value = root.val;
        }
        //searches for the left first
        if (root.left != null){
            SearchForBottom(root.left, row+1);
        }
        
        if (root.right != null){
            SearchForBottom(root.right, row+1);
        }
        
    }
    
    
   
}