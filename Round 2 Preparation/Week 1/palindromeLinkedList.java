//https://leetcode.com/problems/palindrome-linked-list/
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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(head != null){
            result.add(head.val);
            head = head.next;
        }
        
        return checkPalindrome(result); 
    }
    public boolean checkPalindrome(ArrayList<Integer> numList){
        int firstLeg = 0;
        int lastLeg = numList.size() - 1;
        while(firstLeg < lastLeg){
            if(Integer.compare(numList.get(firstLeg), numList.get(lastLeg)) != 0 ){
                return false;
            }
            firstLeg++;
            lastLeg--;
        }
        return true;
    }
}