class Solution {
    public boolean containsCycle(char[][] grid) {
        HashSet<String> seen = new HashSet<>();
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){                
                if(!seen.contains(row+","+col) && goDFS(grid,row,col,seen,-1 + "," + -1)){
                    //System.out.println(seen);
                    return true;
                }
            } 
        }
        return false;
            
        
    }
    public boolean goDFS(char[][] grid,int row, int col,HashSet<String> seen,String parent){
        String currCell = row+","+col;
        //directions
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        seen.add(row + "," + col);
        for(int index = 0; index < directions.length; index++){
            int tempCol = col+ directions[index][0];
            int tempRow = row + directions[index][1];
            
            if(0 <= tempRow  && tempRow < grid.length && 0 <= tempCol && tempCol < grid[tempRow].length && grid[row][col] == grid[tempRow][tempCol] && !parent.equals(tempRow+","+tempCol)){
                               
                if(seen.contains(tempRow+","+tempCol)){
                    return true;
                }
                
                if(goDFS(grid,tempRow,tempCol,seen,currCell)){
                        return true;
                }
            }
        }
        return false;
    }
}
