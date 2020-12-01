//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<Integer, ArrayList<Integer>> nodeMapper= new HashMap<>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        buildAdjecencyList(root,K,nodeMapper);
        LinkedList<Node> queue = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        queue.add(new Node(0,target.val));
        while(queue.size() != 0){
            Node node = queue.remove();
            seen.add(node.val);
            if(node.distance == K){
                result.add(node.val);
            }else if(node.distance >  K){
                break;
            }
            for(int index = 0; index < nodeMapper.get(node.val).size(); index++){
                if(!seen.contains(nodeMapper.get(node.val).get(index))){
                    queue.add(new Node(node.distance+1,nodeMapper.get(node.val).get(index)));
                }
            }
        }
        return result;
        
    }
    public void buildAdjecencyList(TreeNode root,int K,HashMap<Integer, ArrayList<Integer>> nodeMapper){
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0){
            TreeNode node = queue.remove();
            //Building map from parent to children
            if(nodeMapper.containsKey(node.val)){
                if(node.left != null){
                    nodeMapper.get(node.val).add(node.left.val);
                }
                if(node.right != null){
                    nodeMapper.get(node.val).add(node.right.val);
                }
            }else{
                ArrayList<Integer> newList = new ArrayList<>();
                nodeMapper.put(node.val, newList);
                if(node.left != null){
                    nodeMapper.get(node.val).add(node.left.val);
                    
                }
                if(node.right != null){
                    nodeMapper.get(node.val).add(node.right.val);
                }
            }
            //Building the reverse map from child to parent
            if(node.left != null){
                queue.add(node.left);
                    if(nodeMapper.containsKey(node.left.val)){
                        nodeMapper.get(node.left.val).add(node.val);
                    }else{
                        ArrayList<Integer> newList = new ArrayList<>();
                        nodeMapper.put(node.left.val, newList);
                        nodeMapper.get(node.left.val).add(node.val);
                    }
                    
                }
            
             if(node.right != null){
                 queue.add(node.right);
                    if(nodeMapper.containsKey(node.right.val)){
                        nodeMapper.get(node.right.val).add(node.val);
                    }else{
                        ArrayList<Integer> newList = new ArrayList<>();
                        nodeMapper.put(node.right.val, newList);
                        nodeMapper.get(node.right.val).add(node.val);
                    }
                }
        }
    }
}
class Node{
    int distance;
    int val;
    public Node(int dis, int value){
        this.distance = dis;
        this.val = value;
    }
}
