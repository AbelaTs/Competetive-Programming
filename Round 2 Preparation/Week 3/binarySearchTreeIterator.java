//https://leetcode.com/problems/binary-search-tree-iterator/
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
class BSTIterator {
    TreeNode myRoot;
    LinkedList<Integer> queue;

    public BSTIterator(TreeNode root) {
        myRoot = root;
        queue = new LinkedList<Integer>();
        sortTree(myRoot);
        
    }
    
    /** @return the next smallest number */
    public int next() {
        return queue.poll();
        
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();       
    }
    
    public void sortTree(TreeNode root){
        if(root != null){
        if(root.left != null){
          sortTree(root.left);
        }
        
        queue.add(root.val);
        
        
        if(root.right != null){
         sortTree(root.right);
        }
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */