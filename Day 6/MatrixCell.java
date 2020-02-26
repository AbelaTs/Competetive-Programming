//https://leetcode.com/problems/matrix-cells-in-distance-order/
import java.util.Arrays;
import java.util.HashMap;
class MatrixCell {
    static int[][] result;//stores the final result after sorted
    static int[][] matrix_values;// stores each coordinates of the matrix
    //Insertion sort
    public static void sort(int[][] list){
        int[] temp_holder; // temorarily holds data
        for(int index = 1; index < list.length;index++){
            int counter = index;
            int i_count = 0;
            while(counter > 0){
                if(list[counter][i_count]<list[counter-1][i_count]){
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

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        result = new int[R*C][2];
        int[][] sum_index = new int[R*C][2];
        matrix_values = new int[R*C][2];
        int[] given = new int[]{r0,c0};
        int result_counter = 0;
        int sum = 0; // stores distance of each coordinate
        int counter = 0;
        // getting each matrix values
        for(int i=0; i < R;i++){
            for(int j=0; j<C;j++){
               matrix_values[counter] = new int[]{i,j};
               counter++;
               
            }
           
        }
        
        //Storing each index distance
        int count = 0;
        for(int i=0; i < matrix_values.length; i++){
            sum = 0;
            
            for(int j=0; j<2;j++){
               
               sum += Math.abs(given[j] - matrix_values[count][j]);  
            }
            sum_index[count] = new int[]{sum,count};
            count++;
        }
        //Sort the index with respect to the their sum
        sort(sum_index);


        //Adding each coordinate to the final result array according to their index
         for(int i=0; i < sum_index.length;i++){
                int index = sum_index[i][1];
               result[i] = matrix_values[index];
        }

     
        
        return result;
    }
   
    public static void main(String args[]){
       int[][] list =  allCellsDistOrder(2,3,1,2);
    }
}