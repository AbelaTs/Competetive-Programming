//https://leetcode.com/problems/number-of-enclaves/submissions/
class Solution {
    public int numEnclaves(int[][] A) {
        int enclaveCount = 0;
        for(int row =0; row <  A.length; row++){
            for(int col = 0; col <  A[row].length; col++){
                if(row == 0 && A[row][col] == 1){
                    goDFS(A,row,col);
                }else if(col == A[row].length -1 && A[row][col] == 1){
                    goDFS(A,row,col);
                }else if(row == A.length -1  && A[row][col] == 1){
                    goDFS(A,row,col);
                }else if(col == 0 && A[row][col] == 1){
                    goDFS(A,row,col);
                }
            }
        }  
        for(int row =0; row <  A.length; row++){
            for(int col = 0; col <  A[row].length; col++){
               if(A[row][col] == 1){
                  // System.out.println(row+","+col);
                   enclaveCount++;
               }
            }
        } 
        return enclaveCount;
    }
    public void goDFS(int[][]board,int row,int col){
        board[row][col] = 0;
        //left
        if(col-1 >= 0 && board[row][col-1] == 1){
            goDFS(board,row,col-1);
        }
        //right
        if(col + 1 < board[row].length && board[row][col+1] == 1){
            goDFS(board,row,col+1);
        }
        //top
        if(row-1>=0 && board[row-1][col] == 1){
            goDFS(board,row-1,col);
        }
        //bottom
        if(row+1 < board.length && board[row+1][col] == 1){
            goDFS(board,row+1,col);
        }
    }
}