class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[x].length; y++){
                if(x - 1 >= 0 && y - 1 >= 0){
                    if(grid[x-1][y] < grid[x][y-1]){
                        grid[x][y] = grid[x][y] + grid[x-1][y];
                    }else{
                        grid[x][y] = grid[x][y] + grid[x][y-1];
                    }
                }else if(x - 1 >= 0){
                    grid[x][y] = grid[x][y] + grid[x-1][y];
                }else if(y - 1 >= 0){
                    grid[x][y] = grid[x][y] + grid[x][y-1];
                }
        
            }
            
        }
        return grid[grid.length-1][grid[grid.length-1].length-1]; 
    }
    
}