//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
import java.util.ArrayList;
import java.util.HashMap;

class KWeekestRaws {
    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer,Integer> count_map = new HashMap<Integer,Integer>();
        int[][] count_list = new int[mat.length][2];
        ArrayList<Integer> min_list = new ArrayList<Integer>();
        for(int i = 0; i < mat.length; i++){
            int counter = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1){
                    counter++;
                }
            }
            int[] map = {i,counter};
            count_list[i] = map;
        }
        
        sort(count_list);
        for(int i = 0; i < k; i++){
            min_list.add(count_list[i][0]);
        }
        int[] result = new int[min_list.size()];
        for(int i =0; i < min_list.size(); i++){
            result[i] = min_list.get(i);
        }
        return result;
        
        
        
        
        
        
    }
    //Sorts a given list
    public static void sort(int[][] list){
        int[] temp_holder;
        for(int index = 1; index < list.length;index++){
            int counter = index;
            while(counter > 0){
                if(list[counter][1]<list[counter-1][1]){
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