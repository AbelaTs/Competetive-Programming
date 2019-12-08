public class DesignLinkedList {
    
    ListNode head;
    /** Initialize your data structure here. */
    public DesignLinkedList() {
        head  = new ListNode(0);
        head.next = null;
    }
    
     /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
     public int get(int index) {
        ListNode node  = new ListNode(0);
        node.next = head;
        node = node.next; 
        while(index >= 0 && node != null){
                node = node.next;
                index--;
        }
        if(node == null){
            return -1;
        }
        return node.val;
        
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node  = new ListNode(val);
        node.next = head.next;
        head.next = node;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode toAdd = new ListNode(val);
        ListNode node  = new ListNode(0);
        node.next = head;
        node = node.next; 
        while(node.next != null){
            node = node.next;
        }
        node.next = toAdd;
        toAdd.next = null;
        
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode toAdd = new ListNode(val);
        ListNode node  = new ListNode(0);
        node.next = head;
        node = node.next; 
        while(index > 0 && node != null){
                node = node.next;
                index--;
        }
        if(node != null){
            ListNode next = node.next;
            node.next = toAdd;
            toAdd.next = next;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode node  = new ListNode(0);
        node.next = head;
        node = node.next; 
        while(index > 0){
                node = node.next;
                index--;
        }
        if(node.next != null){
            node.next = node.next.next;
        }
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
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */