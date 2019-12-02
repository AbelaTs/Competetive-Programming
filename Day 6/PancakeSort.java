//Not finished yet
import java.io.*; 
import java.util.*; 
class PancakeSort {
    public static List<Integer> pancakeSort(int[] A) {
      List<Integer> result = new ArrayList<Integer>();
      
      for(int i =0; i < A.length; i++){
          if(isSorted(A)){
            for(int j =0; j < A.length; j++){
                result.add(A[i]);
              }
              
            return result;
          }else{
              A = reverse(A);
          }
      }
      return result;
       
    }
    public static int[] reverse(int[] list){
        int[] copy = list;
        int counter = 0;
        for(int i = copy.length-1; i >= 0;i--){
            list[counter] = copy[i];
            counter++;
        }
        return list;
    }
    public static boolean isSorted(int[] list){
        for(int i = 0; i<list.length-1; i++){
            if(list[i] > list[i+1]){
                return false;
            }  
        }
        return true;
    }
    public static void main(String args[]){
        int[] list = {5,4,3};
        List<Integer> sorted = pancakeSort(list);
        System.out.println(sorted.get(0));
    }
}