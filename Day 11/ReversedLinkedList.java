//https://leetcode.com/problems/reverse-linked-list/
public class ReversedLinkedList{

    public ListNode reverseList(ListNode head) {
        ListNode nextNode;
        ListNode previousNode = null;
        if(head != null){
        while(head.next != null){
            nextNode = head.next;
            head.next = previousNode;
            previousNode = head;
            head = nextNode;

        }
        head.next = previousNode;
        }

        return head;
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
 