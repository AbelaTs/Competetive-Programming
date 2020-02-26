//https://leetcode.com/problems/implement-queue-using-stacks
import java.util.ArrayList;

class MyQueue {

    ArrayList<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new ArrayList<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.add(x);   
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int num = stack.get(0);
        stack.remove(0);
        return num;
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.get(0);
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack.size() != 0){
            return false;
        }
        return true;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */