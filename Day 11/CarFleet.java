import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Random;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int fleet_num = 0;
          Double[][] check_fleet = new Double[position.length][2];
          HashMap<Double,Double> pos_time = new HashMap<Double,Double>();
         
          ArrayList<Double> fleeted = new ArrayList<Double>();
          int list_counter = 0;
          //Putting the positions along with their time at that position
          for(int i=0; i<position.length; i++){
              pos_time.put(Double.valueOf(position[i]),Double.valueOf(speed[i]));
              
          }
          if(position.length != 0){
              position = mergeSort(position);//sort the posititions in decreasing order
          }
         
             
          
   
          for(int j = 0; j < position.length; j++ ){
             
             
              //Add the time of each of the two cars to reach the target                
                
                          int distance = target - position[j];
                          
                          Double time = Double.valueOf(distance)/pos_time.get(Double.valueOf(position[j])); 
                          check_fleet[list_counter] = new Double[]{time,Double.valueOf(position[j])};//Registering each time at each position until target
                          list_counter++;
              
          }
       
  
              //Checking if the two cars are fleets by checking their time to reach their target
              if(check_fleet.length != 0){
              Double slowest_car_time = check_fleet[0][0];
              Double slowest_car = check_fleet[0][1];
              for(int i = 1; i< position.length; i++){
                      
                      if(slowest_car_time >= check_fleet[i][0] ){
                         
                          if(!fleeted.contains(slowest_car) && !fleeted.contains(check_fleet[i][1])){
  
                              fleet_num++;
                              fleeted.add(check_fleet[i-1][1]);
                              fleeted.add(check_fleet[i][1]);
                          }
                          if(!fleeted.contains(check_fleet[i][1])){
                              fleeted.add(check_fleet[i][1]);
                          }
                          
  
                      }else{
                           if(!fleeted.contains(slowest_car)){
                              fleet_num++;
                          }
                          slowest_car_time =  check_fleet[i][0];
                          slowest_car = check_fleet[i][1];
                      }
                      
                  }
                  if(!fleeted.contains(slowest_car)){
                      fleet_num++;
                  }
                 
                 
              }
          
            
          
                   
          return fleet_num;
      }
      
      //Sorts a given list in decreasing order with Merge sort
      public static int[] merge(int[] left_list,int[] right_list){
          int merge_list_length = left_list.length + right_list.length;
          int[] merge_list = new int[merge_list_length];
          int left_pointer = 0;
          int right_pointer = 0;
          
          int merged_list_pointer = 0;
  
          while(merged_list_pointer < merge_list_length){
             if(left_pointer < left_list.length && right_pointer < right_list.length){
                  if(left_list[left_pointer] > right_list[right_pointer]){
                      merge_list[merged_list_pointer] = left_list[left_pointer];
                      left_pointer++;
                  }else{
                  merge_list[merged_list_pointer] = right_list[right_pointer];
                  right_pointer++;
                  }
                  merged_list_pointer++;
  
  
             }else{
                 if(left_pointer >= left_list.length){
                     for(int i = right_pointer; i< right_list.length; i++){
                         merge_list[merged_list_pointer] = right_list[right_pointer];
                         right_pointer++;
                         merged_list_pointer++;
                     }
                 }else if(right_pointer >= right_list.length){
                      for(int i = left_pointer; i< left_list.length; i++){
                          merge_list[merged_list_pointer] = left_list[left_pointer];
                          left_pointer++;
                          merged_list_pointer++;
                  }
                 }
             }
             
          }
  
          return merge_list;
      }
  
      // sorts a gien list in a decreasing order
      public static int[] mergeSort(int[] list){
          int[] left_list = Arrays.copyOfRange(list,0,list.length/2);
          int[] right_list = Arrays.copyOfRange(list,list.length/2,list.length);
  
          if(list.length == 1){
              return list;
          }else{
              left_list = mergeSort(left_list);
              right_list = mergeSort(right_list);
          }
          return merge(left_list,right_list);
  
  
      }
    public static void main(String args[]){
        int[] p = {10,8,0,5,3};
        int[] s= {2,4,1,1,3};
        int res = carFleet(12, p, s);
        System.out.println(res);
    }
}

