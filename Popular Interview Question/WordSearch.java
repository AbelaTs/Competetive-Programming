import java.util.HashSet;


class WordSearch {
    public boolean exist(char[][] board, String word) {
        HashSet<String> seen = new HashSet<String>();
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col] == word.charAt(0)){
                    boolean res = search(row,col,board,"",word,seen,0);
                    if(res){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    //Search dfs
    public boolean search(int row, int col,char[][] board,String consString,String original,HashSet<String> seen,int original_index){
        //check if it is the end of board
        if(row > board.length || col > board[row].length){
            if(original_index == original.length()-1){
                return true;
            }
            //if not the same us the original remove it self from seen list
            seen.remove(row+","+col);
            return false;
        }
        boolean top = false;
        boolean bottom = false;
        boolean left = false;
        boolean right = false;
        //visit it
        seen.add((row)+","+col);
            //if the constructed string so far is equal to the original string
            if(original_index == original.length()-1){
                return true;
            }
            //search for neighbours
             //top
            if(row-1 >= 0 && !seen.contains((row-1)+","+col) && board[row-1][col] == original.charAt(original_index+1)){
                top = search(row-1,col,board,consString,original,seen,original_index+1);
            }
            //left
            if(col-1 >= 0 && !seen.contains(row+","+(col-1)) && board[row][col-1] == original.charAt(original_index+1)){
                left = search(row,col-1,board,consString,original,seen,original_index+1);
            }
            //bottom
            if(row+1 < board.length && !seen.contains((row+1)+","+col) && board[row+1][col] == original.charAt(original_index+1)){
                bottom = search(row+1,col,board,consString,original,seen,original_index+1);
            }
            //right
            if(col + 1 < board[row].length && !seen.contains(row+","+(col+1)) && board[row][col+1] == original.charAt(original_index+1)){
                right = search(row,col+1,board,consString,original,seen,original_index+1);
            }
            
        if(top || bottom || left || right){
            return true;
        }
        seen.remove(row+","+col);
        return false;
        
    }
   
}
