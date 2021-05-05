//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int lvls = levels(root);
        return dfs(root,1,lvls);
    }
    
    private TreeNode dfs(TreeNode node,int curlvl,int levels){
        if(node==null) return null;
        if(node.left==null && node.right==null && curlvl==levels) return node;
        TreeNode lefttree = dfs(node.left,curlvl+1,levels);
        TreeNode righttree = dfs(node.right,curlvl+1,levels);
        if(lefttree==null && righttree==null) return null;
        if(lefttree!=null && righttree==null) return lefttree;
        if(lefttree==null && righttree!=null) return righttree;
        return node;
    }
    
    private int levels(TreeNode node){
        if(node==null) return 0;
        return 1+Math.max(levels(node.left),levels(node.right));
    }
}
