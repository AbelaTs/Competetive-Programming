class Solution {
    public boolean exist(char[][] board, String word) {
        int index = 0;
        HashSet<String> seen = new HashSet<>();
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col] == word.charAt(index)){
                    if(goDFS(board,word,row,col,index,seen)){
                        return true;
                    }else{
                       
                        index = 0;
                    }
                }
            }
        }
        return false;
    }
    public boolean goDFS(char[][] board, String word, int row,int col,int index,HashSet<String> seen){
        if(board[row][col] == word.charAt(index)){
            if(index == word.length()-1){
                return true;
            }
            boolean left = false;
            boolean right = false;
            boolean top = false;
            boolean bottom = false;
                seen.add(row+","+col);
                //add left
                if(col-1 >= 0 && !seen.contains(row + "," + (col-1))){
                   left =  goDFS(board,word,row,col-1,index+1,seen);
                }
                //add right
                if(col + 1 < board[row].length && !seen.contains(row +","+(col+1))){
                    right = goDFS(board,word,row,col+1,index+1,seen);
                }
                //add top
                if(row-1 >= 0 && !seen.contains((row-1) + "," + col)){
                    top = goDFS(board,word,row-1,col,index+1,seen);
                }
                //add bottom
                if(row + 1 < board.length && !seen.contains((row+1) +","+col)){
                    bottom = goDFS(board,word,row+1,col,index+1,seen);
                }
                if(left || right || bottom || top){
                    return true;
                }
            
        }
        seen.remove(row+","+col);
        
        return false;
    }
}
