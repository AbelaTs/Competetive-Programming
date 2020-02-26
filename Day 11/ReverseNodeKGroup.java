//https://leetcode.com/problems/reverse-nodes-in-k-group/
import java.util.ArrayList;
// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
public class ReverseNodeKGroup {
    //Reverses a part of the list starting from the given index
  public static void reverse(int[] list, int index){
      int rounds;
      if(index != 0){
       rounds = list.length / index;// how many times it has to iterate 
      }else{
       rounds = 0;  
      }
      int[] temp = new int[index*rounds]; // stores the the reversed numberes in the given range
      int counter = 0; // index counter for the reverse list
      int iterator = 0;
      int end = 0;//point where it should stop adding to the reverse list
      int start = index;//point where it begins adding to the reverse
      while(iterator < rounds){

          for(int i = start - 1; i >= end; i--){
              temp[counter] = list[i];
              counter++;
          }
          iterator++;
         
          end += index; // reassigning the where it should end 
          start += index; // reassigning the point where it should start reversing
         
          

      }
      for(int i = 0; i < temp.length; i++){
              list[i] = temp[i];
          }
      
  }
  //Reverses nodes
  public static ListNode reverseKGroup(ListNode head, int k) {
      ArrayList<Integer> node_values = new ArrayList<Integer>();
      ListNode start = new ListNode(0);
      ListNode start_head = new ListNode(0);
      start.next = start_head;
      if(head != null){
          while(head != null){
              node_values.add(head.val);
              head = head.next;
          }
          int[] values = new int[node_values.size()];
          //converting the array list of node values to list
          for(int i = 0; i < node_values.size(); i++){
              values[i] = node_values.get(i);
          } 

          //reversing the list starting from the given index
          reverse(values, k); // k-1 is b/c index starts from zero

          //creating the linked list for the reversed values
          for(int i = 0; i< values.length; i++){
              start_head.next = new ListNode(values[i]);
              start_head = start_head.next;
          }

          return start.next.next;
          
      }else{
          return head;
      }
      
      
  }
}