class ClosestToOrigin {
    public static int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        double[][] distance_index = new double[points.length][2];
        int[] origin = new int[]{0,0};
        double sum = 0;
        for(int i=0; i<points.length; i++){
         
           sum = Math.sqrt(Math.pow(points[i][0],2) + Math.pow(points[i][1],2));
           
          
           distance_index[i] = new double[]{sum,i};
            
        }
        //SelectionSort
        for(int i=1; i<distance_index.length; i++){
                int counter = i;
                while(counter > 0){
                    if(distance_index[counter][0] < distance_index[counter-1][0]){
                            double[] temp = distance_index[counter-1];
                            distance_index[counter-1] = distance_index[counter];
                            distance_index[counter] = temp;
                            counter--;
                    }else{
                        break;
                    }
                }
            
        }
        //
        for(int i = 0; i<K; i++){
            result[i] = points[(int) distance_index[i][1]];
            
        }
   
        return result;
    }
    public static void main(String args[]){
        int[][] points = {{68,97},{34,-84},{60,100},{2,31},{-27,-38},{-73,-74},{-55,-39},{62,91},{62,92},{-57,-67}};
            kClosest(points,2);
    }
}