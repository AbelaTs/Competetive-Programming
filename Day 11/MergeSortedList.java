
 //Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
 
public class MergeSortedList{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode start = new ListNode(0);
        start.next = head;
        if(l1 == null && l2 !=null){
            return l2;
        }else if(l1 != null && l2 != null){
                while(l1 != null && l2 !=null){
                    if(l1.val <= l2.val){
                        head.next = l1;
                        head = head.next;
                        l1 = l1.next;
                    }else{
                        head.next = l2;
                        head = head.next;
                        l2 = l2.next;

                    }


                }
                
            
                if(l1 == null && l2 != null){
                    head.next = l2;
                }else if(l2 == null & l1 != null){
                    head.next = l1;
                }


            
        }else if(l1 != null && l2 ==null){
            return l1;
        }
     
        return start.next.next; 
    }
}