class UniequPathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for(int row = 0; row < obstacleGrid.length; row++){
            for(int col = 0; col < obstacleGrid[row].length; col++){
                if(obstacleGrid[row][col] == 1){
                    obstacleGrid[row][col] = 0;
                }else{
                    if(row - 1 >= 0 && col - 1 >= 0){
                        //System.out.println(row + " : " + col);
                        obstacleGrid[row][col] = obstacleGrid[row-1][col] + obstacleGrid[row][col-1];
                    }else if(row - 1 >= 0){
                        //System.out.println(row + " : " + col + " : value " + obstacleGrid[row-1][col]);
                        obstacleGrid[row][col] = obstacleGrid[row-1][col];
                    }else if(col - 1>= 0){
                        //System.out.println(row + " : " + col);
                        obstacleGrid[row][col] = obstacleGrid[row][col-1];
                    }else{
                        obstacleGrid[row][col] = 1;
                    }
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[obstacleGrid.length - 1].length - 1];
    }
}