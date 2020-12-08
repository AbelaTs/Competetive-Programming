//https://leetcode.com/problems/find-largest-value-in-each-tree-row/submissions/
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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(0,root));
        HashMap<Integer,Integer> distMapper = new HashMap<>();
        while(queue.size() != 0){
            Node poppedNode = queue.remove();
            if(!distMapper.containsKey(poppedNode.level)){
                distMapper.put(poppedNode.level,poppedNode.value.val);
            }else{
                distMapper.put(poppedNode.level, Math.max(distMapper.get(poppedNode.level),poppedNode.value.val));
            }
            if(poppedNode.value.left != null){
                queue.add(new Node(poppedNode.level + 1,poppedNode.value.left));
            }
            if(poppedNode.value.right != null){
                queue.add(new Node(poppedNode.level + 1,poppedNode.value.right));
            }
        }
        int[] distArray = new int[distMapper.size()];
        for(Integer key :  distMapper.keySet()){
            distArray[key] = distMapper.get(key);
        }
        List<Integer> result = new ArrayList<>();
        for(int index = 0; index < distArray.length; index++){
            result.add(distArray[index]);
        }
        return result;
        
    }
}
class Node{
    int level;
    TreeNode value;
    public Node(int lev,TreeNode val){
        this.level = lev;
        this.value = val;
    }
}
