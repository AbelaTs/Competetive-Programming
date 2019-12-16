import java.util.ArrayList;

import org.graalvm.compiler.nodes.spi.NodeValueMap;

// Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
class InsertionSortLinkList {
    public ListNode insertionSortList(ListNode head) {

        ArrayList<Integer> node_values = new ArrayList<Integer>();// array-list to store each node values
        ListNode sorted_head = new ListNode(0);
        ListNode start = new ListNode(0);
        start.next = sorted_head;
        if(head != null){
            while(head != null){
                node_values.add(head.val);// storing the node values
                head = head.next;
            }

            int[] sorted_node_values = new int[node_values.size()];
            for(int i = 0; i < node_values.size(); i++){
                sorted_node_values[i] = node_values.get(i);
            }
            sort(sorted_node_values);// sorting node values using insertion sort
 
            //Creating the linked list
            for(int i = 0; i < sorted_node_values.length; i++){
                sorted_head.next  = new ListNode(sorted_node_values[i]);
                
                sorted_head = sorted_head.next;
            }
            return start.next.next;
    }else{
        return head;
    }



}
 //Sorts a given list with insertion sort
 public static void sort(int[] list){
    int temp_holder;
    for(int index = 1; index < list.length;index++){
        int counter = index;
        while(counter > 0){
            if(list[counter]<list[counter-1]){
                temp_holder = list[counter-1];
                list[counter-1] = list[counter];
                list[counter] = temp_holder;
                counter--;
            }else{
                break;
            }
        }
    }
   
}
}