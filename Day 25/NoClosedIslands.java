class Solution {
    public static int closedIsland(int[][] grid) {
        ArrayList<String> seen = new ArrayList<String>();
        int counter = 0;
        HashMap<String,Integer> mapper = new HashMap<String,Integer>();
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == 0 && !seen.contains(row + "," + col)){
                    if(search(grid,row,col,seen,island)){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
    public static boolean search(int[][] grid,int row, int col,ArrayList<String> seen, ArrayList<String> island){
        if(grid[row][col] == 1){
            return true;
        }
        boolean left = false;
        boolean right = false;
        boolean top = false;
        boolean bottom = false;
        if(!seen.contains(row + "," +col)){
            seen.add(row + "," +col);
            if(row - 1 >= 0){
                top = search(grid,row-1,col,seen,island);
            }
            if(col - 1 >= 0){
                left = search(grid,row,col-1,seen,island);
            }
            if(row + 1 < grid.length){
                bottom = search(grid,row+1,col,seen,island);
            }
            if(col + 1 < grid[row].length){
                right = search(grid,row,col+1,seen,island);
            }
        }else{
            return true;
        }
      
        if(left && right && top && bottom){
            return true;
        }
        
        return false;
        
    }
}