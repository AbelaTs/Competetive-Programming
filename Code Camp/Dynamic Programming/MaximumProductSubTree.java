import java.util.ArrayList;

// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class MaximumProductSubTree {
    public int maxProduct(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        getSum(root,nodes);
        int total_sum = nodes.get(nodes.size()-1);
        Double max_product = 1.0;
        for(int i = 0; i < nodes.size(); i++){
            Double prod = (double)(total_sum - nodes.get(i)) * (double)nodes.get(i);
            if(prod > max_product){
                max_product = prod;
            }
        }
        
        return (int)(max_product % (1000000007));
        
        
    }
    public int getSum(TreeNode root,ArrayList<Integer> list){
        if(root.left == null && root.right == null){
            list.add(root.val);
            return root.val;
        }
        int left_sum = 0;
        int right_sum = 0;
        if(root.left != null){
            left_sum = getSum(root.left,list);
        }
        if(root.right != null){
            right_sum = getSum(root.right,list);
        }
        //System.out.println(root.val + " : " +left_sum +","+right_sum);
        root.val = root.val + left_sum + right_sum;
        list.add(root.val);
        return root.val;
        
    }
}
