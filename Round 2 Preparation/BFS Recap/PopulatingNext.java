//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        root.next = null;
        queue.add(root);
        while(queue.size() != 0){
            Node popped = queue.remove();
            if(popped.left != null){
                popped.left.next = popped.right;
                if(popped.next != null){
                    popped.right.next = popped.next.left;
                }
                queue.add(popped.left);
                queue.add(popped.right);
            }
        }
        return root;
        
    }
}