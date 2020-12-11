//https://leetcode.com/contest/weekly-contest-150/problems/maximum-level-sum-of-a-binary-tree/
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
    public int maxLevelSum(TreeNode root) {
        HashMap<Integer,Integer> levelDistanceMapper = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        int[] maxSum = new int[]{1,Integer.MIN_VALUE};
        queue.add(new Node(1,root));
        while(queue.size() != 0){
            Node nodePopped = queue.remove();
            if(levelDistanceMapper.containsKey(nodePopped.level)){
                levelDistanceMapper.put(nodePopped.level,levelDistanceMapper.get(nodePopped.level)+nodePopped.treeNode.val);
            }else{
                levelDistanceMapper.put(nodePopped.level,nodePopped.treeNode.val);
            }
            if(nodePopped.treeNode.left != null){
                queue.add(new Node(nodePopped.level+1,nodePopped.treeNode.left ));
            }
            if(nodePopped.treeNode.right != null){
                 queue.add(new Node(nodePopped.level+1,nodePopped.treeNode.right));
            }
        }
        for(Integer key : levelDistanceMapper.keySet()){
            if(levelDistanceMapper.get(key) > maxSum[1]){
                maxSum[1] = levelDistanceMapper.get(key);
                maxSum[0] = key;
            }else if(levelDistanceMapper.get(key) == maxSum[1] && key < maxSum[0]){
                maxSum[1] = levelDistanceMapper.get(key);
                maxSum[0] = key;
            }
        }
        return maxSum[0];
    }
}
class Node{
    int level;
    TreeNode treeNode;
    public Node(int value, TreeNode node){
        level = value;
        treeNode = node;
    }
}