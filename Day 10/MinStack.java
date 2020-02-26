//https://leetcode.com/problems/min-stack/
import java.util.ArrayList;

public class MinStack {

    ArrayList<Integer> stack;
    public MinStack() {
        stack = new ArrayList<Integer>();

    }
    
    public void push(int x) {
        
        stack.add(x);
        
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.remove(stack.size() - 1);
        }
    }
    
    public int top() {
        if(!stack.isEmpty()){ 
           
            return stack.get(stack.size() - 1);
        }
        return 0;
    }
   
    
    public int getMin() {
        if(!stack.isEmpty()){
            int min = stack.get(stack.size() - 1);
            for(int x = stack.size() -1; x >= 0; x--){
                if(stack.get(x) <= min){
                    min = stack.get(x);
                }
            }
            return min;
        }
        return 0;
        
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