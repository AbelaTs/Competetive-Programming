//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int counter = 0;
        int totalLength = 0;
        ListNode counterNode = head;
        while(counterNode != null){
            totalLength ++;
            counterNode = counterNode.next;
        }
       
        ListNode tracker = new ListNode(0);
        tracker.next = head;
        ListNode previous = tracker;
        while(head != null){
            if(totalLength - counter == n){
                previous.next = head.next;
                break;
            }
            previous = head;
            head = head.next;
            counter++;
        }
        return tracker.next;
        
    }
}