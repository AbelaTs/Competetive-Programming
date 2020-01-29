import java.util.HashMap;
import java.util.Random;
public class CountSorting{
    public static void countSort(int[] list){
        int counter = 0;
        //finding the largest number
        int largest = list[0];
        for(int i=0; i<list.length; i++){
            if(list[i] > largest){
                largest = list[i];
            }
        }
        
        //Setting the counting array
        int[] count_sort = new int[largest+1];
        for (int x=0; x < count_sort.length; x++){
            count_sort[x] = 0;
        }
      
        //Counting occurance of each member
        for(int y=0; y<list.length; y++){
            count_sort[list[y]] += 1;
        }
        
        //resorting the array
        for(int j=0; j<count_sort.length; j++){
            while(count_sort[j] > 0){
                list[counter] = j;
                counter++;
                count_sort[j]--;
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
        int[] list = randomGenerator(10000);
        countSort(list);
        for(int i=0; i<list.length;i++){
            System.out.println(list[i]);
        }
    }
}