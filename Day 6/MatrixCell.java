class Solution {
    int[][] result;
    int[][] matrix_values;
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        result = new int[R*C][2];
        matrix_values = new int[R*C][2];
        int[] given = new int[]{r0,c0};
        int[] sum_list = new int[R*C];
        int[] index_order = new int[R*C];
        int sum_counter = 0;
        int result_counter = 0;
        HashMap sum_order = new HashMap<Integer,Integer>();
        int sum = 0;
        
        // getting each matrix values
        for(int i=0; i < R;i++){
            for(int j=0; j<C;j++){
               matrix_values[j] = new int[]{i,j};
            }
        }
        
        //Storing each index distance
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C;j++){
               sum += Math.abs(given[j] - matrix_values[i][j]);  
            }
            sum_order.put(i,sum);
        }
        
        //Makint the sum list
        for(Object value : sum_order.values()){
            int s = (int) value;
            sum_list[sum_counter] = s;
            sum_counter++;     
        }
        Arrays.sort(sum_list);
        //putting index in order
        for(int i=0; i< sum_list.length; i++){
            for(Object key : sum_order.keySet()){
                int value = (int) sum_order.get(key);
                if(value == sum_list[i]){
                    int index = (int) key;
                    index_order[i] = index; 
                } 
            }
        }
        
        //
         for(int i=0; i < R;i++){
            for(int j=0; j<C;j++){
                int index = index_order[j];
               result[j] = matrix_values[index];
            }
        }
        
        
        
     
        
        return result;
    }
}