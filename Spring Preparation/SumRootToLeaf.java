//https://leetcode.com/problems/sum-root-to-leaf-numbers/
class Solution {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        numbers(root,0);
        return sum;
    }
    public void numbers(TreeNode root, int prev){
        if(root==null) return;
        prev=prev*10 + root.val;
        if(root.left==null && root.right==null){
            sum=sum+prev;
            prev=0;
        }
        numbers(root.left,prev);
        numbers(root.right,prev);
    }
}