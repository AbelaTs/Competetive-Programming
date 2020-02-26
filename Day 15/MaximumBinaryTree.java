//https://leetcode.com/problems/maximum-binary-tree/
import java.util.Arrays;
// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
      if(nums.length > 0){  
        int max = nums[0];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,index));
         
        node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,index+1,nums.length));
        return node;
        
      }else{
        return null;
    }
}
}