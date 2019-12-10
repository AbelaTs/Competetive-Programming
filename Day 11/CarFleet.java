import java.util.ArrayList;
import java.util.HashMap;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int[][] position_time = new int[position.length][2];
        int fleet_num = 0;
        Double[][] check_fleet = new Double[position.length][2];
       
        ArrayList<Double> fleeted = new ArrayList<Double>();
        int list_counter = 0;
        //Putting the positions along with their time at that position
        for(int i=0; i<position.length; i++){
            position_time[i] = new int[]{position[i],speed[i]};
        }
        sort(position_time);
 
        for(int j = 0; j < position_time.length; j++ ){
           
           
            //Add the time of each of the two cars to reach the target                
              
                        int distance = target - position_time[j][0];
                        Double time = Double.valueOf(distance)/position_time[j][1]; 

                        check_fleet[list_counter] = new Double[]{time,Double.valueOf(position_time[j][0])};//Registering each time at each position until target
                        list_counter++;
            
        }
     

            //Checking if the two cars are fleets by checking their time to reach their target
            for(int i = 1; i< position.length; i++){
                if(check_fleet[i][0] <= check_fleet[i-1][0] ){
                    if(!fleeted.contains(check_fleet[i][1]) && !fleeted.contains(check_fleet[i-1][1])){
                        fleet_num++;
                    }
                    fleeted.add(check_fleet[i-1][1]);
                    fleeted.add(check_fleet[i][1]);
                    
                }
            }
          
        //Check for single fleets
        for(int i = 0; i<position.length; i++){
            if(!fleeted.contains(Double.valueOf(position[i]))){
               
                fleet_num++;
            }
        }           
        return fleet_num;
    }



    //Sorts a given list in decreasing order
    public static void sort(int[][] list){
        int[] temp_holder;
        for(int index = 1; index < list.length;index++){
            int counter = index;
            while(counter > 0){
                if(list[counter][0] > list[counter - 1][0]){
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
    public static void main(String args[]){
        int[] p = {10,8,0,5,3};
        int[] s= {2,4,1,1,3};
        int res = carFleet(12, p, s);
        System.out.println(res);
    }
}