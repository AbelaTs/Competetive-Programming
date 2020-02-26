//https://leetcode.com/problems/two-city-scheduling/
class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        sort(costs);
        int min_sum = 0;
        int counter = costs.length/2;
        for(int i = 0; i < costs.length; i++){
            if(counter > 0){
                min_sum += costs[i][0];
                counter--;
            }else{
                min_sum += costs[i][1];
            }
        }
        return min_sum;
        
    }
       //Sorts a given list
    public static void sort(int[][] list){
        int[] temp_holder;
        for(int index = 1; index < list.length;index++){
            int counter = index;
            while(counter > 0){
                if(list[counter][0] - list[counter][1]  < list[counter-1][0] - list[counter-1][1]){
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