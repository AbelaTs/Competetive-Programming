//https://leetcode.com/problems/jump-game-v/
import java.util.ArrayList;
import java.util.HashMap;

class JumpV {
    public int maxJumps(int[] arr, int d) {
     HashMap<Integer,ArrayList<Integer>> mapper = new HashMap<Integer,ArrayList<Integer>>();
     for(int i = 0; i < arr.length; i++){
         mapper.put(i,new ArrayList<Integer>());
         //right
         for(int j = 1; j <= d; j++){
             if(i+j < arr.length){
                 if(arr[i] > arr[i+j]){
                    mapper.get(i).add(i+j);

                 }else{
                     break;
                 }
             }
         }
         //left
         
         for(int j = 1; j <= d; j++){
             if(i-j >= 0){
                 if(arr[i] > arr[i-j]){
                     mapper.get(i).add(i-j);   
                 }else{
                     break;
                 }
             }
         }
         
        }
         
         int[] jumpVal = new int[arr.length];
         boolean[] seen = new boolean[arr.length];
         for(int i = 0; i < arr.length; i++){
             getMaxJump(arr,jumpVal,seen,i,mapper);
         }
         int max_jump = 1;
         for(int i = 0; i < jumpVal.length; i++){
             if(jumpVal[i] > max_jump){
                 max_jump = jumpVal[i];
             }
         }
         return max_jump;
        
    }
    public int getMaxJump(int[]arr,int[] jump_count,boolean[] seen,int index,HashMap<Integer,ArrayList<Integer>> mapper){
        if(seen[index]){
            return jump_count[index];
        }
        int max_jump = 0;
        for(Integer neighbour : mapper.get(index)){
            
            int count = getMaxJump(arr,jump_count,seen,neighbour,mapper);
            if(count > max_jump){
                max_jump = count;
            }
        }
        jump_count[index] = max_jump+1;
        seen[index] = true;
        return jump_count[index];
    }
}