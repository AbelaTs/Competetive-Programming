public class DeleteNode{
    public void deleteNode(ListNode node) {
        ListNode node_to_delete;
        int value;
        node_to_delete = node.next;
        value = node_to_delete.val;
        node_to_delete = node_to_delete.next;
        node.next = node_to_delete;
        node.val = value;
    }
    public static void main(String args[]){

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { 
        val = x; 
    }
}