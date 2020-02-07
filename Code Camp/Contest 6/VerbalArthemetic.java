import java.util.ArrayList;
import java.util.HashMap;

class VerbalArthemetic {
    public boolean canReach(int[] arr, int start) {
        HashMap<Integer, Boolean> mapper = new HashMap<Integer, Boolean>();
        int zeroIndex = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                mapper.put(i,true);
                zeroIndex = i;
            }else{
                if(i - arr[i] >= 0){
                    if(arr[i - arr[i]] == 0){
                        mapper.put(i,true);
                    }
                }
                if(i + arr[i] < arr.length){
                    if(arr[i + arr[i]] == 0){
                        mapper.put(i,true);
                    }
                }
                if(!mapper.containsKey(i)){
                    mapper.put(i,false);
                }
            }
            
        }
        ArrayList<Integer> seen = new ArrayList<Integer>();
        return search(arr,start,mapper,seen);
        
        
       
        
    }
    public boolean search(int[] arr, int index,HashMap<Integer, Boolean> mapper,ArrayList<Integer> seen){
        
        if(mapper.get(index)){
             
            return true;
        }
        if(seen.contains(index)){
           
            return false;
        }
        boolean left = false;
        boolean right = false;
        seen.add(index);
        if(index - arr[index] >= 0){
            
            left = search(arr,index - arr[index],mapper,seen);
            
        }
        if(index + arr[index] < arr.length){
            
            right = search(arr,index+arr[index],mapper,seen);
        }
        if(left || right){
            return true;
        }
        return false;
    }
    
}