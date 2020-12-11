//https://leetcode.com/problems/as-far-from-land-as-possible/
class Solution {
    public int maxDistance(int[][] grid) {
        int maxDistance = -1;
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] seen = new int[grid.length][grid.length];
        //finiding all ones
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid.length; col++){
                if(grid[row][col] == 1){
                    queue.add(new int[]{row,col});
                    seen[row][col] = 1;
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(queue.size() != 0){
            int queueSize = queue.size();
            for(int queueIndex = 0; queueIndex < queueSize; queueIndex++){
                int[] coordinate = queue.remove();
                for(int index = 0; index < directions.length; index++){
                    int newRow = coordinate[0] + directions[index][0];
                    int newCol = coordinate[1] + directions[index][1];
                    if(newCol >= 0 && newCol < grid.length && newRow >=0 && newRow < grid.length && seen[newRow][newCol] != 1){
                        queue.add(new int[]{newRow,newCol}); 
                        seen[newRow][newCol] = 1;
                    }
                }
                
            }
            maxDistance++;
            
        }
        return maxDistance > 0 ? maxDistance : -1;
        
    }
}