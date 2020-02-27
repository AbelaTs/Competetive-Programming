//https://leetcode.com/problems/most-frequent-subtree-sum/
import java.util.ArrayList;
import java.util.HashMap;


//Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class MostFrequentSubTree {
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        HashMap<Integer,Integer> sum_counter = new HashMap<Integer,Integer>();
        getSum(root,sum_counter);
        int most_freq = 0;
        for(Integer value : sum_counter.values()){
            if((int) value > most_freq){
                most_freq = value;
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(Integer key : sum_counter.keySet()){
            if((int) sum_counter.get(key) == most_freq){
                result.add(key);
            }
        }
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }
    public int getSum(TreeNode root,HashMap<Integer,Integer> sum_counter){
        if(root.left == null && root.right == null){
            if(sum_counter.containsKey(root.val)){
                sum_counter.put(root.val, sum_counter.get(root.val)+1);
            }else{
                sum_counter.put(root.val,1);
            }
            return root.val;
        }
        int left_sum = 0;
        int right_sum = 0;
        if(root.left != null){
            left_sum = getSum(root.left,sum_counter); 
        }
        if(root.right != null){
            right_sum = getSum(root.right,sum_counter);
        }
        int total_sum = left_sum + right_sum + root.val;
        if(sum_counter.containsKey(total_sum)){
            sum_counter.put(total_sum, sum_counter.get(total_sum)+1);
        }else{
            sum_counter.put(total_sum,1);
        }
        return total_sum;
        
    }
}