import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class FriendCircle {
    public int findCircleNum(int[][] M) {
        HashMap<Integer,ArrayList<Integer>> mapper = new HashMap<Integer,ArrayList<Integer>>();
        int circle_counter = 0;
        //make the adjecency list
        for(int row = 0; row < M.length; row++){
            for(int col = 0; col < M[row].length; col++){
                //if direct friendship exist
                if(M[row][col] == 1){
                    if(mapper.containsKey(row)){
                        mapper.get(row).add(col);
                    }else{
                        mapper.put(row,new ArrayList<Integer>());
                        mapper.get(row).add(col);
                    }
                }
            }
        }
        //DFS search
        ArrayList<Integer> seen = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for(Integer key : mapper.keySet()){
            if(!seen.contains(key)){
                circle_counter++;
                stack.push(key);
                while(!stack.empty()){
                    int std = stack.pop();
                    if(!seen.contains(std)){
                        seen.add(std);
                    }
                    //search for indirect friends
                    for(int indirect : mapper.get(std)){
                        if(!seen.contains(indirect)){
                            stack.push(indirect);
                        }
                    }
                    
                }
            }
        }
        
        return circle_counter;
    }
}