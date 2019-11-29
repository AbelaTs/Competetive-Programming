//Author : Abel Tsegaye

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.io.*; 
import java.util.*; 
public class PrefixCalculator{
    public static void calculate(String input){
        String operand1 = "";
        String operand2 = "";
        char operator;
        Stack n_stack = new Stack(input);
        for(char o : n_stack.stack){
            if(String.isDigit(o)){
                operand2 += String.toString(o);
            }else{

                operand1 += String.toString(o);
                if(n_stack.stack[n_stack.stack.length - 1] == o){
                    if(operand2 == null){
                        operand2 = String.toString(o);
                    }
                }
            }
        }
        System.out.println(operand1 + ", "+ operand2);


    }
  
    public static void main(String args[]){
        String sample = "*2*34"; 
        Stack n_stack = new Stack(sample);
        for(int i = 0; i< sample.length(); i++){
            System.out.println(n_stack.pop());
        }
        
    }


}
//Stack
class Stack{
        ArrayList<String> stack;
       public Stack(String input){
           stack = new ArrayList<String>();
           for(int x = input.length()-1; x >= 0; x--){
               stack.add(Character.toString(input.charAt(x)));
           }
       }
       public String pop(){
      
           String num = stack.get(stack.size() - 1);
           stack.remove(stack.size() - 1);
           
           return num;
       }
       public void push(String c){
            stack.add(c);
       }
   }
