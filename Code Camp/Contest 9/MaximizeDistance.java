//https://leetcode.com/contest/weekly-contest-88/problems/maximize-distance-to-closest-person
import java.util.ArrayList;

class MaximizeDistance {
    public int maxDistToClosest(int[] seats) {
        ArrayList<Integer> seats_taken = new ArrayList<Integer>();
        int max_distance = 0;
        boolean started = false;
        int counter = 0;
        int last_seat_taken = 0;
        for(int i = 0; i < seats.length; i++){
            if(started && seats[i] == 0){
                counter++;
            }
            if(seats[i] == 1){
                last_seat_taken = i;
                if(!started){
                    started = true;
                    counter = 0;
                    if(i > max_distance){
                        //System.out.println(i);
                        max_distance = i;
                    }
                }else{
                    int average_place = counter - (int) Math.ceil(counter/2);
                    if(average_place > max_distance){
                        //System.out.println("average " + average_place);
                        max_distance = average_place;
                    }
                    counter = 0;
                }
                
            }
            
        }
        
        if((seats.length-1) - last_seat_taken > max_distance){
            //System.out.println("last " + ((seats.length-1) - last_seat_taken));
            max_distance = (seats.length-1) - last_seat_taken;
        }
        
        
        return max_distance;
        
    }
}