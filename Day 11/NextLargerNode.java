import java.util.ArrayList;

import org.graalvm.compiler.core.gen.NodeLIRBuilder;

public class NextLargerNode {
    public int[] nextLargerNodes(ListNode head) {
    
        ArrayList<Integer> node_list = new ArrayList<Integer>();
        while(head != null){
            node_list.add(head.val);
            head = head.next;
        }

        int[] result = new int[node_list.size()];
        for(int i = 0; i<node_list.size(); i++){
            
            for(int j=i+1; j<node_list.size(); j++){
                if((int) node_list.get(j) > (int) node_list.get(i)){
                    result[i] = (int) node_list.get(j);
                    break;
                }

            }
            if(Integer.toString(result[i]).length() < 1){
                result[i] = 0;
            }
        }
        
        
        return result;
       
        
    }
}
//Definition for singly-linked list.
class ListNode {
    int val;
   ListNode next;
   ListNode(int x) { val = x; }
}