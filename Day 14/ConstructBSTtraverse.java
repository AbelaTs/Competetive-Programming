import java.util.Arrays;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class ConstructBSTtraverse {
 
    public static TreeNode bstFromPreorder(int[] preorder) {
        
        if(preorder.length == 3){
           TreeNode node = new TreeNode(preorder[0]);
           if(preorder[1] < node.val){
               node.left = new TreeNode(preorder[1]);
           }else if(preorder[1] > node.val){
               TreeNode node1  = new TreeNode(preorder[1]);
               node.right = node1;
               if(preorder[2] < node1.val){
                   
                   node1.left = new TreeNode(preorder[2]);
               }else if(preorder[2] > node1.val){
                   node1.right = new TreeNode(preorder[2]);
               }
               
           }
            //if left node is already taken
            if(node.left != null){
                if(preorder[2] > node.val){
                    node.right = new TreeNode(preorder[2]);  
                }else if(preorder[2] < node.val){
                    if(preorder[2] < node.left.val){
                        node.left.left = new TreeNode(preorder[2]);
                    }else if(preorder[2] > node.left.val){
                        node.left.right = new TreeNode(preorder[2]);
                    }
                }
            }
           
            
            
            return node;
            
        }else if(preorder.length == 2){
            TreeNode node = new TreeNode(preorder[0]);
            if(preorder[1] < node.val){
               node.left = new TreeNode(preorder[1]);
            }else if(preorder[1] > node.val){
               node.right = new TreeNode(preorder[1]);
            }
            return node;
        }else if(preorder.length == 1){
            TreeNode node = new TreeNode(preorder[0]);
            return node;
        }else if(preorder.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        int counter = 0;
        for(int i = 1; i < preorder.length; i++){
            if(preorder[i] <= node.val){
                counter++;
            }else{
                break;
            }
        }
        int[] l1 = Arrays.copyOfRange(preorder,1,counter+1);
        node.left = bstFromPreorder(l1);
        int[] l2 = Arrays.copyOfRange(preorder,counter+1,preorder.length);
        node.right = bstFromPreorder(l2);
        return node;
    }

    
}