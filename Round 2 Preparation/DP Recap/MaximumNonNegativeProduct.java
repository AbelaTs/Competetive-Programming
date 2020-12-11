//https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
class Solution {
    public int maxProductPath(int[][] grid) {
        int mod = 1000000007;
        int[][] directions = {{-1,0},{0,-1}};
        long[][][] mem = new long[grid.length][grid[0].length][2];
        for(int row  = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                mem[row][col] = new long[2];
                long minOfNeigh = Long.MAX_VALUE;
                long maxOfNeigh = Long.MIN_VALUE;
                //checking for each directions
                for(int index = 0; index < directions.length; index++){
                    int newCol =  col +  directions[index][0];
                    int newRow =  row +  directions[index][1];
                    if(newCol >= 0 && newRow >= 0){
                        minOfNeigh = Math.min(minOfNeigh,mem[newRow][newCol][0]);
                        maxOfNeigh = Math.max(maxOfNeigh,mem[newRow][newCol][1]);   
                    }
                }
                
                if(minOfNeigh != Long.MAX_VALUE && maxOfNeigh != Long.MIN_VALUE){
                    minOfNeigh *= grid[row][col];
                    maxOfNeigh *= grid[row][col];
                }else{
                    minOfNeigh = grid[row][col];
                    maxOfNeigh = grid[row][col];
                }
                
                mem[row][col][0] = Math.min(minOfNeigh,maxOfNeigh);
                mem[row][col][1] = Math.max(minOfNeigh,maxOfNeigh);
                
            }
        }
        long result =  Math.max(mem[mem.length-1][mem[mem.length-1].length-1][0],mem[mem.length-1][mem[mem.length-1].length-1][1]);
        
        if(result < 0){
            return -1;
        }
        return (int) (result % mod);
    }
}