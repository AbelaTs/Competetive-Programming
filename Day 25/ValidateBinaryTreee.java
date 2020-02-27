import java.util.ArrayList;
import java.util.Collections;

//https://leetcode.com/problems/validate-binary-search-tree/submissions/
//Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        State result = validate(root);
        if(!result.status){
            return false;
        }
        return true;
    }
    
    public State validate(TreeNode root){
       if(root.left == null && root.right == null){
           State st = new State(root.val,true);
           st.children.add(root.val);
       }
       State state = new State(root.val,true);
       state.children.add(root.val);
        //left check
       if(root.left != null){
           State left = validate(root.left);
           if(left.status){
               Collections.sort(left.children, Collections.reverseOrder()); 
               //if parent is greater than the largest element coming from the left
               if(root.val > left.children.get(0)){
                 state.children.addAll(left.children);
               }else{
                   state.status = false;
               }
           }else{
               state.status = false;
           }
       }
        //right check
        if(root.right != null){
           State right = validate(root.right);
           if(right.status){
               Collections.sort(right.children);
               //if parent is less than the minimum that comes from the right 
               if(root.val < right.children.get(0)){
                 state.children.addAll(right.children);
               }else{
                   state.status = false;
               }
           }else{
               state.status = false;
           }
       }
       return state;
    }
}
class State{
    int value;
    boolean status;
    ArrayList<Integer> children;
    public State(int val,boolean stat){
        value = val;
        status = stat;
        children = new ArrayList<Integer>();
    }
}