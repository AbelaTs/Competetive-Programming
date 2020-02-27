//https://leetcode.com/problems/min-stack/
import java.util.ArrayList;
class MinStack {
    ArrayList<State> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<State>();
    }
    
    public void push(int x) {
        if(stack.size() == 0){
            stack.add(new State(x,x));
        }else{
            int prev = stack.get(stack.size()-1).min;
            if(x < prev){
                stack.add(new State(x,x));
            }else{
                stack.add(new State(x,prev));
            }
        }
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1).self;
    }
    
    public int getMin() {
        return stack.get(stack.size()-1).min;
    }
}
class State{
    int self;
    int min;
    public State(int val,int mn){
        self = val;
        min = mn;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
