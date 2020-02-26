//https://leetcode.com/contest/weekly-contest-77/problems/max-increase-to-keep-city-skyline/
class MaxIncreaseSkyLine {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] top_bottom = new int[grid.length];
        int[] right_left = new int[grid.length];
        int increase_amount = 0;
        //original top bottom skyline
        for(int i = 0; i < top_bottom.length; i++){
            int[] temp = new int[grid.length];
            for(int j = 0; j < grid.length; j++){
                temp[j] = grid[j][i]; 
            }
            top_bottom[i] = getMaxElement(temp);
        }
        //original left right skyline
        for(int i = 0; i < right_left.length; i++){
            int[] temp = new int[grid.length];
            for(int j = 0; j < grid.length; j++){
                temp[j] = grid[i][j]; 
            }
            right_left[i] = getMaxElement(temp);
        }
        
        //
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                int compare_val = Math.min(top_bottom[j],right_left[i]);
                if(grid[i][j] < compare_val){
                    increase_amount += compare_val - grid[i][j];
                }
            }
        }
        
        return increase_amount;
    }
    public int getMaxElement(int[] list){
        int max_num = list[0];
        for(int i = 1; i < list.length; i++){
            if(list[i] > max_num){
                max_num = list[i];
            }
        }
        return max_num;
    }
}