//https://leetcode.com/problems/merge-k-sorted-lists/
import java.util.Iterator;
import java.util.PriorityQueue;

//Definition for singly-linked list. 
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }
 
class MergeKsortedList {
    public ListNode mergeKLists(ListNode[] lists) {
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      for(int i = 0; i < lists.length; i++){
          ListNode temp = lists[i];
          while(temp != null){
              minHeap.add(temp.val);
              temp = temp.next;
          }
      }
      ListNode res = new ListNode(0);
      ListNode temp = res;
        
      Iterator iterator = minHeap.iterator();
      while(iterator.hasNext()){
          ListNode node = new ListNode(minHeap.poll());
          temp.next = node;
          temp = temp.next;
      }
          
      
        return res.next;
    }
}