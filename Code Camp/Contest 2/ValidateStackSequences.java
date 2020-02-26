//https://leetcode.com/problems/validate-stack-sequences/
import java.util.ArrayList;

class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
         CStack stack = new CStack();
         int counter = 0;
         boolean noMatch = true;
         for(int num : popped){
             
             noMatch = true;
            if(stack.isEmpty()){
                stack.push(pushed[counter]);
            }
             //check if last elements matches the popped num
                 if(stack.peek() == num){
                     stack.pop();
                     noMatch = false;
                     
                 }else{
                     counter++;
                     while(counter < pushed.length){
                         stack.push(pushed[counter]);
                        
                         if(stack.peek() == num){
                             stack.pop();
                             noMatch = false;
                             break;
                         }
                         counter++;

                     }
                     if(counter == pushed.length && noMatch){
                         
                         return false;
                     }
                 }
             
         }
            
        
        return true;
    }
}
//Custom stack
class CStack{
    ArrayList<Integer> stack;
    public CStack(){
        stack = new ArrayList<Integer>();
    }
    public int pop(){
        int num = (int) stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return num;
    }
    public void push(int c){
        stack.add(c);
    }
    public int peek(){
        int num = (int) stack.get(stack.size() - 1);
        return num;
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public void addFirst(int num){
        
    }
}