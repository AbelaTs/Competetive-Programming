//https://leetcode.com/problems/2-keys-keyboard/
import java.util.ArrayList;

class Keys2 {
    public int minSteps(int n) {
       ArrayList<Integer> A_present = new ArrayList<Integer>(); 
       A_present.add(1);
       int step_counter = 0;
       int copied = 0;
       int written = 1;
       while(written < n){
           //if the word to be written is divisible by already written then we can copy and paste
           if(n % written == 0){
               copied = written;//copy
               step_counter++;
           }
           step_counter++;//pasting the copied
           written += copied;
           
           
       }
       return step_counter;
        
    }
}