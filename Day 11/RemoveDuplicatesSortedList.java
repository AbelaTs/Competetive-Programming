//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
 }
 
class RemoveDuplicatesSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = new ListNode(0);
        ListNode previous = head;
        start.next = head;
        
        while(head != null){
            if(head.next != null){
                if(head.val == head.next.val){
                    head.next = head.next.next;
                }else{
                    head = head.next;
                }
            }else{
                head = head.next;
            }
            
        }
        return start.next;
    }
}