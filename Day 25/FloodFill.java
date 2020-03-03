
//https://leetcode.com/problems/flood-fill/
import java.util.ArrayList;
import java.util.Stack;

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target= image[sr][sc];
        Stack<State> stack = new Stack<State>();
        stack.push(new State(sr,sc,target));
        image[sr][sc] = newColor;
        ArrayList<State> seen = new ArrayList<State>();
        while(!stack.empty()){
            State current = stack.pop();
            if(!seen.contains(current)){
                seen.add(current);
            }
            //top
            if(current.row - 1 >= 0){
                if(!seen.contains(new State(current.row - 1,current.column,image[current.row - 1][current.column]))){
                    if(image[current.row - 1][current.column] == target){
                        image[current.row - 1][current.column] = newColor;
                        stack.push(new State(current.row - 1,current.column,image[current.row - 1][current.column]));
                    }
                }
            }
            //bottom
            if(current.row + 1 < image.length){
                if(!seen.contains(new State(current.row + 1,current.column,image[current.row + 1][current.column]))){
                    if(image[current.row + 1][current.column] == target){
                        image[current.row + 1][current.column] = newColor;
                        stack.push(new State(current.row + 1,current.column,image[current.row + 1][current.column]));
                    }
                }
            }
            //right
            if(current.column + 1 < image[current.row].length){
                if(!seen.contains(new State(current.row,current.column+1,image[current.row][current.column+1]))){
                    if(image[current.row][current.column+1] == target){
                        image[current.row][current.column+1] = newColor;
                        stack.push(new State(current.row,current.column+1,image[current.row][current.column+1]));
                    }
                }
            }
            //left
            //right
            if(current.column - 1 >= 0){
                if(!seen.contains(new State(current.row,current.column-1,image[current.row][current.column-1]))){
                    if(image[current.row][current.column-1] == target){
                        image[current.row][current.column-1] = newColor;
                        stack.push(new State(current.row,current.column-1,image[current.row][current.column-1]));
                    }
                }
            }
            
        }
        return image;
    }
}
class State{
    int row;
    int column;
    int value;
    public State(int r,int col, int val){
        row = r;
        column = col;
        value = val;
    }
    @Override
    public int hashCode() {
        String hash = "" + row + " " + column;
        return hash.hashCode();
    }
    @Override
    public boolean equals(Object o){
        State newState = (State) o;
        return this.row == newState.row && this.column == newState.column;
    }
}