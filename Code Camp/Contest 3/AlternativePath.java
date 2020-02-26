//https://leetcode.com/problems/shortest-path-with-alternating-colors/
import java.util.ArrayList;
import java.util.HashMap;

class AlternativePath {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] res = new int[n];
        for(int i = 1; i < res.length; i++){
            res[i] = getDistanceBFS(i,red_edges,blue_edges);
         
        }
        return res;
        
        
    }
    public int getDistanceBFS(int n, int[][] red_edges, int[][] blue_edges){
        HashMap<Integer,ArrayList<Integer>> r_edges = new HashMap<Integer,ArrayList<Integer>>();
        HashMap<Integer,ArrayList<Integer>> b_edges = new HashMap<Integer,ArrayList<Integer>>();
        //Making adjecency list for red edges
        for(int i = 0; i < red_edges.length; i++){
            if(!r_edges.containsKey(red_edges[i][0])){
                ArrayList<Integer> dest = new ArrayList<Integer>();
                dest.add(red_edges[i][1]);
                r_edges.put(new Integer(red_edges[i][0]),dest);
            }else{
                ArrayList<Integer> existing = r_edges.get(new Integer(red_edges[i][0]));
                existing.add(red_edges[i][1]);
                r_edges.put(red_edges[i][0],existing);
            }
        }
        //Making adjecency list for blue edges
        for(int i = 0; i < blue_edges.length; i++){
            if(!b_edges.containsKey(blue_edges[i][0])){
                ArrayList<Integer> dest = new ArrayList<Integer>();
                dest.add(blue_edges[i][1]);
                b_edges.put(blue_edges[i][0],dest);
            }else{
                ArrayList<Integer> existing = b_edges.get(new Integer(blue_edges[i][0]));
                existing.add(blue_edges[i][1]);
                b_edges.put(blue_edges[i][0],existing);
            }
        }
        
        MyQueue que = new MyQueue();
        State startBlue = new State(1,0);
        State startRed = new State(0,0);
        que.push(startBlue);
        que.push(startRed);
        HashMap<State,Integer> Distance_mapper = new HashMap<State,Integer>();
        Distance_mapper.put(startBlue,0);
        Distance_mapper.put(startRed,0);
        int distance = 0;
        while(!que.empty()){
            State st = que.pop();
            
            if(st.color == 0){
                if(b_edges.containsKey(st.value)){
                    ArrayList<Integer> nodes = b_edges.get(st.value);
                     distance++;
                    for(int i = 0; i < nodes.size(); i++){
                        State state = new State(1,nodes.get(i));
                        if(!Distance_mapper.containsKey(state)){
                            Distance_mapper.put(state,Distance_mapper.get(st)+1);
                            que.push(state);
                        }
                        
                    }
                }
            }else{
                
                if(r_edges.containsKey(st.value)){
                    ArrayList<Integer> nodes = r_edges.get(st.value);
                     distance++;
                    for(int i = 0; i < nodes.size(); i++){
                        State state = new State(0,nodes.get(i));
                        if(!Distance_mapper.containsKey(state)){
                            Distance_mapper.put(state,Distance_mapper.get(st)+1);
                            que.push(state);
                        }
                    }
                }
                
            }
        }
        
        
        State r_state = new State(0,n);
        State b_state = new State(1,n);
        
        if(!Distance_mapper.containsKey(r_state) && !Distance_mapper.containsKey(b_state)){
            return -1;
        }else if(!Distance_mapper.containsKey(r_state)){
            int b_dis = Distance_mapper.get(b_state);
            return b_dis;
        }else if( !Distance_mapper.containsKey(b_state)){
            int r_dis = Distance_mapper.get(r_state);
            return r_dis;
        }
        
        int b_dis = Distance_mapper.get(b_state);
        int r_dis = Distance_mapper.get(r_state);
        
        if(r_dis <= b_dis){
            return r_dis;
        }else{
            return b_dis;
        }
        
    }
    
}


class State{
    int color;//0 for red and 1 for blue
    int value;
    public State(int c, int v){
        color = c;
        value = v;
    }
    
    @Override
    public boolean equals(Object o) {
        State newState = (State) o;
        return this.value == newState.value && this.color == newState.color;
    }

    @Override
    public int hashCode() {
        if (color == 0) {
            return value;
        } else {
            return value + 500;
        }
    }
    
}
//Custom queue
class MyQueue {

    ArrayList<State> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new ArrayList<State>();
    }
    
    /** Push element x to the back of queue. */
    public void push(State x) {
        stack.add(x);   
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public State pop() {
        State num = stack.get(0);
        stack.remove(0);
        return num;
    }
    
    /** Get the front element. */
    public State peek() {
        return stack.get(0);
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack.size() != 0){
            return false;
        }
        return true;
    }
}