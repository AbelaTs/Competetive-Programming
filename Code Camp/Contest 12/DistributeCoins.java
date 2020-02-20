//Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class DistributeCoins {
    public int distributeCoins(TreeNode root) {
        State st = passCoins(root);
        return st.move_counter;
        
    }
    public State passCoins(TreeNode root){
        if(root.left == null && root.right == null){
            int toPass = root.val - 1;
            State st = new State(Math.abs(toPass),toPass);
            return st;
            
        }
        int coin_gathered = root.val;
        int move_counter = 0;
        //get the number of moves needed by children and coins from children and add it to it self
        if(root.left != null){
            State left = passCoins(root.left);
            move_counter += left.move_counter;
            coin_gathered += left.coin;
        }
        
        if(root.right != null){
           State right = passCoins(root.right);  
           move_counter += right.move_counter;
           coin_gathered += right.coin;
        }
        
        int toPass = coin_gathered - 1;
        return new State(move_counter+Math.abs(toPass),toPass);
        
        
    }

}
class State{
    int move_counter;
    int coin;
    public State(int move,int coin_pass){
        move_counter = move;
        coin = coin_pass;
    }
}