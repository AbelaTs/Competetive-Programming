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
//https://leetcode.com/problems/maximum-width-of-binary-tree/
 class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer,Integer> minMap = new HashMap<>();
        HashMap<Integer,Integer> maxMap = new HashMap<>();
        int maxWidth = 1;
        goSearching(root,minMap,maxMap,1,1);
        for(Integer key : minMap.keySet()){
            maxWidth = Integer.max(maxWidth,Math.abs(maxMap.get(key)-minMap.get(key))+1);   
        }
        return maxWidth;
        
    }
    public void goSearching(TreeNode root, HashMap<Integer,Integer> minMap, HashMap<Integer,Integer> maxMap,int level,int position){
        if(root == null){
            return;
        }
        if(!minMap.containsKey(level)){
            minMap.put(level,position);
            maxMap.put(level,position);
        }else{
            minMap.put(level,Integer.min(minMap.get(level),position));
            maxMap.put(level,Integer.max(maxMap.get(level),position));
        }
        goSearching(root.left,minMap,maxMap,level+1,(2*position)-1);
        goSearching(root.right,minMap,maxMap,level+1,2*position);
        
    }
}