//https://leetcode.com/problems/count-submatrices-with-all-ones/submissions/
class Solution {
    public int numSubmat(int[][] mat) {
       int minStepLeft = 0;
       int subMatCounter = 0;
       for(int row = 0; row < mat.length; row++){
           for(int col = 0; col < mat[row].length; col++){
               if(mat[row][col] > 0){
              //left search
               if(col - 1>=0){
                   mat[row][col] = mat[row][col-1] + 1;
               }
               //topSearch
           
                   int counter = row;
                   int min = mat[row][col];
                   while(counter >= 0 && mat[counter][col] > 0){
                        min = Math.min(mat[counter][col],min);
                        subMatCounter += min;
                        counter--;
                   }
               
               }
       }
       
    }
         return subMatCounter;
    }
}
