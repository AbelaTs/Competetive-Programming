
 // Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode previous = new ListNode(0);//Saves the previous node
        previous.next = start;
        previous = previous.next;
        if(head != null){
        while(head != null){
            if(head.next != null){
                ListNode temp = head.next;
                head.next = temp.next;
                temp.next = head;
                head = temp;
                previous.next = head;
                previous = previous.next;
                previous = previous.next;//getting to the node just before the next node to be swapped
                head = head.next.next;
                
            }else{
                break;
            }
        }
        }
        return start.next;
    }
}