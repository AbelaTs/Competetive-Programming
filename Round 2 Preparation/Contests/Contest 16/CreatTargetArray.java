//https://leetcode.com/contest/weekly-contest-181/problems/create-target-array-in-the-given-order/
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        Node initial = new Node(nums[0]);
        for(int indCounter = 1; indCounter < nums.length; indCounter++){
            int counter = index[indCounter];
            if(counter > 0){
                Node temp = initial;
                Node previous = null;
                while(counter > 0){
                    previous = temp;
                    temp = temp.next;
                    counter --;
                }
                Node newNode = new Node(nums[indCounter]);

                if(temp != null){
                    previous.next = newNode;
                    newNode.next = temp;
                }else{
                    previous.next = newNode;
                }
            }else{
                Node newNode = new Node(nums[indCounter]);
                Node temp = initial;
                initial = newNode;
                initial.next = temp;
            }
        }
        int[] result = new int[nums.length];
        int indexCounter = 0;
        while(initial != null){
            //System.out.println(initial.value);
            result[indexCounter] = initial.value;
            initial = initial.next;
            indexCounter++;
        }
       return result;
        
    }
}
class Node{
    int value;
    Node next;
    public Node(int val){
        this.value = val;
    }
}
