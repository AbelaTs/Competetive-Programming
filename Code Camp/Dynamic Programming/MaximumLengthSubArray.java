import java.util.ArrayList;
import java.util.HashMap;

class MaximumLengthSubArray {
    public int findLength(int[] A, int[] B) {
        HashMap<Integer,ArrayList<Integer>> mapper = new HashMap<Integer,ArrayList<Integer>>();
        int max_counter = 0;
        //stores the next element of each element in the array
        for(int i = 0; i < A.length; i++){
            if(mapper.containsKey(A[i])){
                if(i+1 < A.length){
                    mapper.get(A[i]).add(i);
                }
            }else{
                mapper.put(A[i],new ArrayList<Integer>());
                mapper.get(A[i]).add(i);
            }
        }
        //check for the sub array
        for(int i = 0; i < B.length; i++){
            if(mapper.containsKey(B[i])){
                //locate the corresponding index in the other array and iterate in both arrays
                for(int index_in_a : mapper.get(B[i])){
                    int counter = 0;
                    int a_index = index_in_a;
                    for(int j = i; j < B.length; j++){
                        if(a_index < A.length){
                            if(A[a_index] == B[j]){
                                //System.out.println(A[a_index] + " : " + B[j]);
                                a_index++;
                                counter++;  
                            }else{
                                break;
                            }   
                        }
                    }
                if(counter > max_counter){
                    max_counter = counter;
                }
                }
                
            }
            
        }
        return max_counter;
        
        
    }
}