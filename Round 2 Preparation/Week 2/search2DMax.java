//https://leetcode.com/problems/search-a-2d-matrix/submissions/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int row = 0; row <  matrix.length; row++){
           
            if(matrix[row].length > 0 && matrix[row][0] <= target && matrix[row][matrix[row].length - 1] >= target){
                for(int col = 0; col <  matrix[row].length; col++){
                    if(matrix[row][col] == target){
                        return true;
                    }
                }
            }else{
                if(matrix[row].length > 0 && matrix[row][0] > target ){
                     break;
                }
               
            }
        }
        return false;
    }
}