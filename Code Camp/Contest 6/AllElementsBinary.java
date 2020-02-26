//https://leetcode.com/contest/weekly-contest-169/problems/all-elements-in-two-binary-search-trees/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
     int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> root_list = new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        getElements(root1,root_list);
        getElements(root2,root_list);
        res.addAll(root_list);
        Collections.sort(res);
        return res;
        
        
    }
    public void getElements(TreeNode root,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left != null){
            getElements(root.left,list);
        }
        if(root.right != null){
            getElements(root.right,list);
        }
        
    }
}