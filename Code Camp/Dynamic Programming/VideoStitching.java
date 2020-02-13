class VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        sort(clips);
        int counter = 0;
        State initial_state = new State(clips[0][0],clips[0][1]);// our state to build our linked list
        State previous = initial_state;
        //if it doesn't start with 0
        if(previous.initial != 0){
               return -1;
        }
        int track_max = initial_state.end;
        for(int i = 1; i < clips.length; i++){
            //if it has already found the end of the video clip then break
            if(previous.end >= T){
                break;
            }
            if(clips[i][0] > previous.initial && clips[i][0] <= previous.end && clips[i][1] > previous.end){
                       //add new level
                       previous.next = new State(clips[i][0],clips[i][1]);
                       previous = previous.next;
                       // after adding the new level search for a better interval
                       for(int j = i+1; j < clips.length; j++){
                           if(clips[j][0] <= track_max && clips[j][1] > previous.end){
                               previous.initial = clips[j][0];
                               previous.end = clips[j][1];
                           }else if(clips[j][0] > track_max && clips[j][1] > previous.end){
                               break;
                           }
                       }
                     //update the maximum end
                       track_max = previous.end;
                       

                   }else if(clips[i][0] == previous.initial && clips[i][1] > previous.end){
                       //if it has the same initial point but has larger interva then replace previous one
                       previous.initial = clips[i][0];
                       previous.end = clips[i][1];
                       //update the maximum end time as well
                       track_max = previous.end;
                       
                   }
           
            
        }
        //if it never found an interval till the end
        if(previous.end < T){
            return -1;
        }
        
        //count the final video intervals
        while(initial_state != null){
            counter++;
            initial_state = initial_state.next;
        }
        return counter;
    }
    
    //Sorts a given list
    public static void sort(int[][] list){
        int[] temp_holder;
        for(int index = 1; index < list.length;index++){
            int counter = index;
            while(counter > 0){
                if(list[counter][0] < list[counter-1][0]){
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

}
class State{
    int initial;
    int end;
    State next;
    public State(int start_time,int end_time){
        initial = start_time;
        end = end_time;
    }
}