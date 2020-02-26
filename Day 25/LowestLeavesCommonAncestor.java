//https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
// Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
 
class LowestLeavesCommonAncestor {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        State ancestor = findAncestor(root);
        return ancestor.node;
        
    }
    public State findAncestor(TreeNode root){
        //return a state when reached to leaf node
        if(root.left == null && root.right == null){
            State state  = new State(root,1);
            return state;
        }
        State left_state = null;
        State right_state = null;
        
        if(root.left != null){
            left_state = findAncestor(root.left);
        }
        if(root.right != null){
            right_state = findAncestor(root.right);
        }
        //if parent recieved left and right state
        if(left_state != null && right_state != null){
            //if left side has greater distance
            if(left_state.level > right_state.level){
                left_state.level += 1;
                return left_state;
            }else if(right_state.level > left_state.level){//if right side has greater distance
                right_state.level += 1;
                return right_state;
            }else{
                //if both states has the same distance it will just realize it self the common ancestor for both side
                if(right_state.level == left_state.level && right_state.node.val != left_state.node.val){
                        left_state.node = root;
                        left_state.level += 1;
                        return left_state;
                }else{ // otherwise it will just return one of them
                    left_state.level += 1;
                    return left_state;
                }
            }
        }else{
            if(left_state == null){
                right_state.level += 1;
                return right_state;
            }else{
                left_state.level += 1;
                return left_state;
            }
        }
    }
}

class State{
    TreeNode node;
    int level;
    public State(TreeNode nde,int dis){
        node = nde;
        level = dis;
    }
}