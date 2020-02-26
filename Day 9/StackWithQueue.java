//https://leetcode.com/problems/implement-stack-using-queues
import java.util.ArrayList;

class MyStack {
    ArrayList<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new ArrayList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
         int num = queue.get(queue.size() - 1);
          queue.remove(queue.size() - 1);
          return num;
    }
    
    /** Get the top element. */
    public int top() {
        return queue.get(queue.size() - 1);
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue.size() != 0){
            return false;
        }
        return true;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */