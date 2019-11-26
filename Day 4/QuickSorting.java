import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
public class QuickSorting{
    static int pivot ;
    static int new_pivot;
    static int temp_holder;
    static int left_pivot_marker;
    static int right_pivot_marker;

    public static int[] quick_sort(int[] list){
        pivot = list.length - 1;
        left_pivot_marker = 0;
        right_pivot_marker = pivot - 1;
      
        if(list.length == 1){
            return list;
        }
        while(left_pivot_marker <= right_pivot_marker){
            //when it reaches the pivot
        if(left_pivot_marker >= right_pivot_marker){
                temp_holder = list[pivot];
                list[pivot] = list[left_pivot_marker];
                list[left_pivot_marker] = temp_holder;
                new_pivot = left_pivot_marker;
               
            
            }

            if(list[left_pivot_marker] <= list[pivot]){
                left_pivot_marker++;
                
            }else{
                if(list[right_pivot_marker] <= list[pivot]){
                    temp_holder = list[left_pivot_marker];
                    list[left_pivot_marker] = list[right_pivot_marker];
                    list[right_pivot_marker] = temp_holder;
                    left_pivot_marker ++;
                    
                  
                }else{
                    right_pivot_marker--;
                }
          }

        }
       return list;
    
    }

    public static int[] merge(int[] left, int[] right){
        int[] result = new int[left.length + right.length];
        int counter = 0;
     
            for(int i = 0; i < left.length; i++){
                result[counter] = left[i];
                counter++;
            }
            for(int j = 0; j < right.length; j++){
                result[counter] = right[j];
                counter++;
            }
        
        return result;
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
        int[] list = {35};
        int[] result = quick_sort(list);
        for(int i= 0; i<result.length;i++){
            System.out.println(result[i]);
        } 
    }
}