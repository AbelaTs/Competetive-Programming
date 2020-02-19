import java.util.ArrayList;
import java.util.HashSet;

// Definition for singly-linked list. 
class ListNode { int val; ListNode
 next; ListNode(int x) { val = x; } }

class Solution {
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> numbers = new HashSet<Integer>();
        ArrayList<Integer> seen = new ArrayList<Integer>();
        int pair_counter = 0;
        for(int i = 0; i < G.length; i++){
            numbers.add(G[i]);
        }
        boolean started = false;
        while(head.next != null){
            if(numbers.contains(head.val)){
                //System.out.println("Val " +head.val);
                if(numbers.contains(head.next.val)){
                    if(!started){
                        pair_counter++;
                    }
                    started = true;
                    seen.add(head.val);
                    seen.add(head.next.val);
                }else{
                    //System.out.println(" no pair " +head.val);
                    started = false;
                    if(!seen.contains(head.val)){
                        pair_counter++;
                    }
                    seen.add(head.val);
                    
                }
            }
            head = head.next;   
        }
        if(!seen.contains(head.val) && numbers.contains(head.val)){
            //System.out.println("pair " +head.val);
            pair_counter++;
        }
    
        return pair_counter;
        
        
    }
}