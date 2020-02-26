//https://leetcode.com/problems/intersection-of-two-arrays/
import java.util.Arrays;
import java.util.HashMap;
class IntersectionArrays {
    public static int[] intersection(int[] num1, int[] num2) {
        HashMap common = new HashMap<Integer,String>();
        
        if(num2.length < num1.length){
            for(int i=0; i<num2.length; i++){
               for(int j=0; j<num1.length; j++)
               {
                   if(num2[i] == num1[j]){
                       if(!common.containsKey(num2[i])){
                             common.put(num2[i],"common");
                       }
                       break;
                   }
               } 
            }
        }else{
            for(int i=0; i<num1.length; i++){
               for(int j=0; j<num2.length; j++)
               {
                   if(num1[i] == num2[j]){
                       if(!common.containsKey(num1[i])){
                           common.put(num1[i],"common");
                       }
                       break;
                   }
               } 
            }
            
        }
        
        int[] common_nums = new int[common.size()];
        int counter = 0;
        for(Object key : common.keySet()){
            int num = (int) key;
            common_nums[counter] = num;
            counter++;
        }
        return common_nums;
    }
    public static void main(String args[]){
        int[] list1 = {1,2,2,3,4,4,5};
        int[] list2 = {2,2,2,2};
        int[] result = intersection(list1,list2);
        for(int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}