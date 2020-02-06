class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[n][m];
        //Initializing the border values with 1
        for(int i = 0; i < matrix.length; i++){
            matrix[i][0] = 1;
            if(i == 0){
                for(int j = 1; j < matrix[i].length; j++){
                    matrix[i][j] = 1;
                }
            }
        }
        //Calculating path for inner cells
        for(int i = 1; i < matrix.length; i++){
           for(int j = 1; j < matrix[i].length; j++){
               matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
           } 
        }
        
        return matrix[n-1][m-1];
       
    }
    
} 