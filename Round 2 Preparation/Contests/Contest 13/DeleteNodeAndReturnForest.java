//https://leetcode.com/contest/weekly-contest-144/problems/delete-nodes-and-return-forest/
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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        HashSet<Integer> toBeDeleted = new HashSet<>();
        for(int index = 0; index < to_delete.length; index++){
            toBeDeleted.add(to_delete[index]);
        }
        return processDeleted(root,result,toBeDeleted,true);
        
        
    }
    public List<TreeNode> processDeleted(TreeNode root, List<TreeNode> nodeList,HashSet<Integer> toBeDeleted,boolean gotDeleted){
        if(root == null){
            return nodeList;
        }
        if(gotDeleted && !toBeDeleted.contains(root.val)){
            nodeList.add(root);
        }
        if(toBeDeleted.contains(root.val)){
            processDeleted(root.left,nodeList,toBeDeleted,true);
            processDeleted(root.right,nodeList,toBeDeleted,true);
        }else{
            processDeleted(root.left,nodeList,toBeDeleted,false);
            processDeleted(root.right,nodeList,toBeDeleted,false);
        }
        if(root.left != null){
            if(toBeDeleted.contains(root.left.val)){
                root.left = null;
            }
        }
        if(root.right != null){
            if(toBeDeleted.contains(root.right.val)){
                root.right = null;
            }
        }
        return nodeList;
    }
}