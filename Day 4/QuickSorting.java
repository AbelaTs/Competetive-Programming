import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
public class QuickSorting{
    static int pivot ;
    static int[] given_list;
    static int new_pivot;
    static int temp_holder;
    static int left_pivot_marker;
    static int right_pivot_marker;

    //Returns the pivot
    public static int quick_sort(int initial,int end){

        left_pivot_marker = initial;
        right_pivot_marker = end;
        pivot = end;
        
        while(left_pivot_marker <= right_pivot_marker){
            
            //when it reaches the pivot
        if(left_pivot_marker == right_pivot_marker){
                temp_holder = given_list[pivot];
                given_list[pivot] = given_list[left_pivot_marker];
                given_list[left_pivot_marker] = temp_holder;
                new_pivot = left_pivot_marker;
                left_pivot_marker++;
            }else{

            if(given_list[left_pivot_marker] <= given_list[pivot]){
                left_pivot_marker++;
                
            }else{
                if(given_list[right_pivot_marker] < given_list[pivot]){
                    temp_holder = given_list[left_pivot_marker];
                    
                    given_list[left_pivot_marker] = given_list[right_pivot_marker];
                    
                    given_list[right_pivot_marker] = temp_holder;
                   
                    left_pivot_marker ++;
                    
                  
                }else{
                    right_pivot_marker--;
                }
          }
        }

        }
       return new_pivot;
    
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

    //Sorts
    public static int Q_sort(int start,int end){
        int new_p = quick_sort(start,end); //Pivot
        int left_end = new_p-1;
        int right_start = new_p+1; 
        if(start < end){
            Q_sort(start,left_end);//sort from start to pivot
            Q_sort(right_start,end);// sort from pivot to end
        }
        
        
        return 0;
        
    }
    

    public static void main(String args[]){
        
       
        int[] list = randomGenerator(1000000);
        given_list = list;
      
        Q_sort(0,given_list.length - 1);
        for(int i=0; i<given_list.length;i++){
            System.out.println(given_list[i]);
        }
        
    }
}