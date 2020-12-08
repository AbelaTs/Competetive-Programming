//https://leetcode.com/problems/path-sum-iii/
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
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int pathSum = 0;
        queue.add(root);
        int counter = 0;
        while(queue.size() != 0){
            TreeNode rootPopped = queue.remove();
            int tempSum =  getSum(rootPopped,0,sum);
            pathSum += tempSum;
            //System.out.println(rootPopped.val + " > " +tempSum);
            if(rootPopped.left != null){
                //System.out.println(rootPopped.left.val);
                queue.add(rootPopped.left);
            }
            if(rootPopped.right != null){
                //System.out.println(rootPopped.right.val);
                queue.add(rootPopped.right);
            }
           
        }
        return pathSum;       
    }
  
    public int getSum(TreeNode root,int sum,int target){
            if(root.left == null && root.right == null){
                sum += root.val;
                if(sum == target){
                    return 1;
                }
                return 0;
            }
            sum += root.val;
            int resultSum = 0;
            if(sum == target){
                resultSum++;
            }
            
            if(root.left != null){
               resultSum += getSum(root.left, sum, target); 
            }

            if(root.right != null){
                resultSum += getSum(root.right, sum, target);
            }
        return resultSum;
    }
        
        
}