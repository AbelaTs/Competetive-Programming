import java.util.HashMap;
import java.util.Random;

public class InsertionSorting{

    //Sorts a given list
    public static void sort(int[] list){
        int temp_holder;
        for(int index = 1; index < list.length;index++){
            int counter = index;
            while(counter > 0){
                if(list[counter]<list[counter-1]){
                    temp_holder = list[counter-1];
                    list[counter-1] = list[counter];
                    list[counter] = temp_holder;
                    counter--;
                }else{
                    break;
                }
            }
        }
       
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
        int[] g_list = randomGenerator(10000);
        sort(g_list);

        for(int i = 0;i < g_list.length; i++){

            System.out.println(g_list[i] + "");
        }
    }
}