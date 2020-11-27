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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        HashMap<Integer,Integer> inorderMap = new HashMap<>();
        for(int index = 0; index < inorder.length; index++){
            inorderMap.put(inorder[index],index);
        }
        return treeBuilder(0,0,inorder.length -1,preorder,inorder,inorderMap);
        
    }
    public TreeNode treeBuilder(int preRoot,int inStart,int inEnd,int[] preorder,int[] inorder,HashMap<Integer,Integer> memo){
        if(inStart > inEnd){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preRoot]);
        int inOrderRoot = memo.get(node.val);
        if(inStart < inOrderRoot){
            node.left = treeBuilder(preRoot+1,inStart,inOrderRoot-1,preorder,inorder,memo);
        }
        if(inOrderRoot < inEnd){
            node.right = treeBuilder(preRoot + (inOrderRoot - inStart) + 1,inOrderRoot+1,inEnd,preorder,inorder,memo);
        }
        return node;
        
    }
} 