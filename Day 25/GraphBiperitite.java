//https://leetcode.com/problems/is-graph-bipartite/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class GraphBipertite {
    public boolean isBipartite(int[][] graph) {
        ArrayList<Integer> node_list = new ArrayList<Integer>();
        //populate node list
        for(int i = 0; i < graph.length; i++){
            node_list.add(i);
        }
        
        HashMap<Integer,ArrayList<Integer>> mapper = new HashMap<Integer,ArrayList<Integer>>();
        
        HashMap<Integer,ArrayList<Integer>> color_mapper = new HashMap<Integer,ArrayList<Integer>>();
        color_mapper.put(1, new ArrayList<Integer>());//1 is for red color
        color_mapper.put(-1, new ArrayList<Integer>());// -1 is for blue color
        //make the adjecency list
        for(int i = 0; i < graph.length; i++){
            mapper.put(i,new ArrayList<Integer>());
            for(int j = 0; j < graph[i].length; j++){
                mapper.get(i).add(graph[i][j]);
            }
        }
        //seen list to keep track of seen nodes
        ArrayList<Integer> seen = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        for(Integer key : mapper.keySet()){
            stack.push(key);//push it to stack
            //DFS 
            while(!stack.empty()){
                int node = stack.pop();
                //if it hasn't been seen
                if(!seen.contains(node)){
                    color_mapper.get(1).add(node);// add it to red color by default 
                    for(int child : mapper.get(node)){
                        //if it has not seen add it with different color
                        if(!seen.contains(child)){
                            stack.push(child);//push the child to stack
                            seen.add(child); 
                            color_mapper.get(-1).add(child);
                        }else{
                            //if it hasbeen seen check if it has the same color with its parent
                            if(color_mapper.get(1).contains(child)){
                                return false;
                            }
                        }
                    }

                }else{
                    //if it has been seen get its previous color
                    int parent_color = 0;
                    if(color_mapper.get(1).contains(node)){
                        parent_color = 1;
                    }else{
                        parent_color = -1;
                    }
                    for(int child : mapper.get(node)){
                        //if it has not seen add it with different color
                        if(!seen.contains(child)){
                            stack.push(child);
                            seen.add(child);
                            if(parent_color == 1){
                                color_mapper.get(-1).add(child);
                            }else{
                                color_mapper.get(1).add(child);
                            }
                        }else{
                            //if it hasbeen seen check if it has the same color with its parent
                            if(color_mapper.get(parent_color).contains(child)){
                                return false;
                            }
                        }
                    }


                }
            }
            
          
            
        }
       
        
        return true;
        
    }
    
}
class State{
    int color;
    int value;
    public State(int clr,int val){
        color = clr;
        val = value;
    }
    @Override
    public int hashCode() {
        String hash = "" + color + " " + value;
        return hash.hashCode();
    }
    @Override
    public boolean equals(Object o){
        State newNode = (State) o;
        return this.color == newNode.color && this.value == newNode.value;
    }
    
    
}