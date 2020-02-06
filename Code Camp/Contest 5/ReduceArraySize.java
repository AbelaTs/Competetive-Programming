import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class ReduceArraySize {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> count_map = new HashMap<Integer,Integer>();
        for(int i = 0; i < arr.length; i++){
            if(count_map.containsKey(arr[i])){
                count_map.put(arr[i],count_map.get(arr[i])+1);
            }else{
                count_map.put(arr[i],1);
            }
        }
        ArrayList<Integer> counts = new ArrayList<Integer>();
        for(Integer value : count_map.values()){
            counts.add((int) value);
        }
        Collections.sort(counts, Collections.reverseOrder());
        int half_len = (int) Math.ceil(arr.length/2);
        int sum = 0;
        int num_counter = 0;
        for(int i = 0; i < counts.size(); i++){
            num_counter++;
            sum += counts.get(i);
            if(sum >= half_len){
                break;
            }
        }
        return num_counter;
    }
}