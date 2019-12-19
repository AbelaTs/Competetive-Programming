
// Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
class BinaryTreePostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
         ArrayList<Integer> result = new ArrayList<Integer>();
        if(root!= null){
           
            addMembers(root, result);  
            result.add(root.val);
            return result;
        }else{
            return result;
        }
    }
    //Reverses the binarty tree starting from the left
    public static void addMembers(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        
        if(root.left != null){
            addMembers(root.left,list);
            list.add(root.left.val);
        }
        
        if(root.right != null){
            addMembers(root.right,list);
            list.add(root.right.val);
        }
       
      
        
    }
}