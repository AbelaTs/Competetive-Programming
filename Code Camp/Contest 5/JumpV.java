//https://leetcode.com/problems/jump-game-v/
import java.util.ArrayList;
import java.util.HashMap;
class JumpV {
    public int maxJumps(int[] arr, int d) {
     HashMap<Integer,ArrayList<Integer>> jumpSites = new HashMap<Integer,ArrayList<Integer>>();
     for(int i = 0; i < arr.length; i++){
         jumpSites.put(i,new ArrayList<Integer>());
         //right
         for(int j = 1; j <= d; j++){
             if(i+j < arr.length){
                 if(arr[i] > arr[i+j]){
                    jumpSites.get(i).add(i+j);

                 }else{
                     break;
                 }
             }
         }
         //left
         for(int j = 1; j <= d; j++){
             if(i-j >= 0){
                 if(arr[i] > arr[i-j]){
                     jumpSites.get(i).add(i-j);   
                 }else{
                     break;
                 }
             }
         }
         
        }
         
         int[] jumpVal = new int[arr.length];
         boolean[] seen = new boolean[arr.length];
         for(int i = 0; i < arr.length; i++){
             getMaxJump(arr,jumpVal,seen,i,jumpSites);
         }
         int maxJump = 1;
         for(int i = 0; i < jumpVal.length; i++){
             if(jumpVal[i] > maxJump){
                 maxJump = jumpVal[i];
             }
         }
         return maxJump;
        
    }
    public int getMaxJump(int[]arr,int[] jumpCount,boolean[] seen,int index,HashMap<Integer,ArrayList<Integer>> jumpSites){
        if(seen[index]){
            return jumpCount[index];
        }
        int maxJump = 0;
        for(Integer neighbour : jumpSites.get(index)){
            
            int count = getMaxJump(arr,jumpCount,seen,neighbour,jumpSites);
            if(count > maxJump){
                maxJump = count;
            }
        }
        jumpCount[index] = maxJump+1;
        seen[index] = true;
        return jumpCount[index];
    }
}