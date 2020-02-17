import java.util.ArrayList;

class CountNegativeNumbers {
    public int countNegatives(int[][] grid) {
        ArrayList<Integer> col_seen = new ArrayList<Integer>();
        ArrayList<Integer> row_seen = new  ArrayList<Integer>();
        int row_length = grid.length - 1;
        int col_length = grid[0].length - 1;
        int negative_counter = 0;
        int col_limit = grid[0].length;
        for(int row = 0; row < grid.length; row++){
                for(int col = 0; col < grid[row].length; col++){
                    if(!col_seen.contains(col)){
                        if(grid[row][col] < 0){
                            //System.out.println(row + " : " + col);
                            negative_counter += ((grid.length - row) * (col_limit - col));
                            col_limit = col;
                            col_seen.add(col);
                            break;
                        }
                    }else{
                        break;
                    }
                }
        }
        return negative_counter;
    }
}