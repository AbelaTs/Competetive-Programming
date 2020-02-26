//https://leetcode.com/problems/design-circular-deque/
//Not finished
import java.util.ArrayList;
class CircularDeque {
    static int size;
    ArrayList<Integer> queue;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public CircularDeque(int k) {
      queue = new ArrayList<Integer>();
      size = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
       if(queue.size() < size){
           queue.add(0,value);
            return true;
       }else{
           return false;
       } 
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
      if(queue.size() < size){
           queue.add(value); 
           return true;
       }else{
           return false;
       } 
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(queue.size() > 0){
           queue.remove(0);  
            return true;
       }else{
           return false;
       }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
         if(queue.size() > 0){
           queue.remove(queue.size()-1);  
            return true;
       }else{
           return false;
       }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(queue.size() > 0){
            return queue.get(0);
       }else{
           return -1;
       }
       
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
       if(queue.size() > 0){
            return queue.get(queue.size()-1);
       }else{
           return -1;
       }
       
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(queue.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(queue.size() == size){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */