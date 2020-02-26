//https://leetcode.com/problems/increasing-order-search-tree/
import java.util.ArrayList;

//Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
       CStack stack = new CStack();
        TreeNode res = new TreeNode(0);
        TreeNode pointer = null;
        pointer = root;
        TreeNode previous = res;
       // stack.push(/;
       while(!stack.isEmpty()  || pointer != null){
           if(pointer != null){
               stack.push(pointer);
               pointer = pointer.left;
           }else{
               pointer = stack.pop();
               previous.right = new TreeNode(pointer.val);
               previous = previous.right;
               
               pointer = pointer.right;
           }
           
           
       }
        return res.right;
    }
   
}

//Custom stack
class CStack{
    ArrayList<TreeNode> stack;
    public CStack(){
        stack = new ArrayList<TreeNode>();
    }
    public TreeNode pop(){
        TreeNode num =  stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return num;
    }
    public void push(TreeNode c){
        stack.add(c);
    }
    public TreeNode peek(){
        TreeNode num = stack.get(stack.size() - 1);
        return num;
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public void addFirst(int num){
        
    }
}