import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
public class RadixSort{
    public static int[] radixSort(int[] list){
        int pointer;
        String[] num_list = new String[list.length];//storage for string form of the input list
        int digit_counter = 0;
        String large;//stores the largest number in the list

        //finding the largest number
        int largest = list[0];
        for(int i=0; i<list.length; i++){
            if(list[i] > largest){
                largest = list[i];
            }
        }
        large = Integer.toString(largest);
        int length_largest = large.length();

        //converting all numbers to string
        for(int i = 0; i <list.length; i++){
            num_list[i] = Integer.toString(list[i]); 
        }

        //Equalizing all digits
        for(int i = 0; i <num_list.length; i++){
            digit_counter = num_list[i].length();
            while(digit_counter < length_largest){
                num_list[i] = "0"+num_list[i];
                digit_counter++;
            }
        }

        String temp;
        pointer = length_largest - 1;
        
        
        //Radix sort
        while(pointer >= 0){
           
            for(int i = 0; i <num_list.length; i++){
                int counter = 0;
                while(counter <= i){
                    //comparing digit of the selected number with each member of the list starting from the beginning
                    if(num_list[i].charAt(pointer) < num_list[counter].charAt(pointer)){
                 
                        int t_counter = i;
                        temp = num_list[i];//temporarily saving the number to be moved first before rearranging
                        //Rearranging the numbers so that we can put the number at the right place
                        while(t_counter > counter){
                            num_list[t_counter] = num_list[t_counter-1];
                            t_counter--;
                        }
                        num_list[counter] = temp;
                       
                        
                        break;
                    }else{
                        counter++;
                    }
                   
                }   
            }
            pointer--;
        }
          //converting sorted array back to integers
          for(int i = 0; i <num_list.length; i++){
            list[i] = Integer.parseInt(num_list[i]); 
        }
        return list;


    }
             //Generates random numbers from up to the given numbers with no duplicates 
             public static int[] randomGenerator(int size){
                Random random = new Random();
                int counter = 0;
                int generatod;
                int[] random_generatod = new int[size];
                HashMap map = new HashMap<Integer,Integer>();
                while(counter < size){
                    Integer num = random.nextInt(size+1);
                    if(!map.containsKey(num)){
                        map.put(num,num);
                        random_generatod[counter] = num;
                        counter++;
        
                    }
                    
                    
                    
                }
                return random_generatod;
                
            }
    public static void main(String args[]){
            int[] list = randomGenerator(10000);
            radixSort(list);
            for(int j = 0; j <list.length; j++){
                System.out.println(list[j]);
            }
           

    }
}