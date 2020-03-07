//https://leetcode.com/problems/rotting-oranges/
import java.util.ArrayList;

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        ArrayList<Orange> mainQueue = new ArrayList<Orange>();
        ArrayList<Orange> tempQueue = new ArrayList<Orange>();
        ArrayList<String> seen = new ArrayList<String>();
        boolean isThereOrange = false;
        
        //get the initial rotten ones
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == 2){
                    mainQueue.add(new Orange(row,col));
                }
                if(grid[row][col] == 1){
                    isThereOrange = true;
                }
                
            }
        }
        //
        int minutes = -1;
        while(!mainQueue.isEmpty()){
            minutes++;
            //transfer rotten oranges from main to temporary queue
            while(!mainQueue.isEmpty()){
                tempQueue.add(mainQueue.get(0));
                mainQueue.remove(0);
            }
            //run bfs for each rotten orange
            while(!tempQueue.isEmpty()){
                Orange current = tempQueue.get(0);
                tempQueue.remove(0);
                grid[current.row][current.col] = 2;
                //top
                if(current.row - 1 >= 0 && grid[current.row-1][current.col] == 1 && !seen.contains((current.row-1) + ","+current.col)){
                    mainQueue.add(new Orange(current.row-1,current.col));
                    seen.add((current.row-1) + ","+current.col);
                }
                //bottom
                if(current.row + 1 < grid.length && grid[current.row+1][current.col] == 1 && !seen.contains((current.row+1) + ","+current.col)){
                    mainQueue.add(new Orange(current.row+1,current.col));
                    seen.add((current.row+1) + ","+current.col);
                }
                //right
                if(current.col + 1 < grid[current.row].length && grid[current.row][current.col+1] == 1 && !seen.contains((current.row) + ","+(current.col+1))){
                    mainQueue.add(new Orange(current.row,current.col+1));
                    seen.add((current.row) + ","+(current.col+1));
                }
                //left
                if(current.col - 1 >= 0 && grid[current.row][current.col-1] == 1 && !seen.contains((current.row) + ","+(current.col-1))){
                    mainQueue.add(new Orange(current.row,current.col-1));
                    seen.add((current.row) + ","+(current.col-1));
                }
            }
        }
        if(!isThereOrange){
            return 0;
        }
         for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == 1){
                    return -1;
                }
            }
         }
        return minutes;
        
    }
}
   
class Orange{
    int row;
    int col;
    public Orange(int r,int c){
        row = r;
        col = c;
    }
}
