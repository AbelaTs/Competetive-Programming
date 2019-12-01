//Author : Abel Tsegaye

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.io.*; 
import java.util.*; 
public class PrefixCalculator{
public static int prefixCalculator(String input){
        Stack n_stack = new Stack();
        String[] given = input.split(" ");
        for(int i = given.length-1; i >= 0; i--){
            if(Character.isDigit(given[i].charAt(0))){
                n_stack.push(given[i]);
            }else{
                char operator = given[i].charAt(0);
                int operand1 = Integer.parseInt(n_stack.pop());
                int operand2 = Integer.parseInt(n_stack.pop());
               // System.out.println(operand1 + " " + operator + " "+operand2);
                switch (operator) {
                    case '+':
                        n_stack.push(Integer.toString(operand1 + operand2));
                        break;
                    case '*':
                        n_stack.push(Integer.toString(operand1 * operand2));
                        break;
                    case '-':
                        n_stack.push(Integer.toString(operand1 - operand2));
                        break;
                    case '/':
                        n_stack.push(Integer.toString(operand1 / operand2));
                        break;
                }
            }
        }
        return Integer.parseInt(n_stack.pop());
    }
  
    public static void main(String args[]){
        String sample = "+ 4 * 3 12"; 
        System.out.println(prefixCalculator(sample)); 
    }


}
//Stack class for stack operation
class Stack{
        ArrayList<String> stack;
       public Stack(){
           stack = new ArrayList<String>();
       }
       public String pop(){
      
           String num = stack.get(stack.size() - 1);
           stack.remove(stack.size() - 1);
           
           return num;
       }
       public void push(String c){
            stack.add(c);
       }
       public String peek(){
            return stack.get(stack.size() - 1);
       }
       public boolean isEmpty(){
           return stack.isEmpty();
       }
   }
