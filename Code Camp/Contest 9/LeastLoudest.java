import java.util.ArrayList;
import java.util.HashMap;

class LeastLoudest {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        HashMap<Integer,ArrayList<Integer>> rich_mapper = new HashMap<Integer,ArrayList<Integer>>();// adjecency least from poor to rich
        HashMap<Integer,Integer> res_mapper = new HashMap<Integer,Integer>();// dictionary for memorization
        //making the adjecency list
        for(int i = 0; i < richer.length; i++){
            if(!rich_mapper.containsKey(richer[i][1])){
                rich_mapper.put(richer[i][1],new ArrayList<Integer>());
                rich_mapper.get(richer[i][1]).add(richer[i][0]);
            }else{
                rich_mapper.get(richer[i][1]).add(richer[i][0]);
            }
        }
        int[] res = new int[quiet.length]; //final result list
        for(int i = 0; i < quiet.length; i++){
                int least_quite = i;// first set the ith person it self as the least quiet
                CStack stack = new CStack();
                State per_state = new State(i,i);
                stack.push(per_state);
                ArrayList<Integer> seen = new ArrayList<Integer>();//seen tracker
                //System.out.println("Already " +  res_mapper.get(i));
                if(res_mapper.containsKey(i)){
                    least_quite = res_mapper.get(i);
                 }else{
                    //search for the least quite
                    while(!stack.isEmpty()){
                          State person_fetched = stack.peek();
                          if(!seen.contains(person_fetched.person)){
                              seen.add(person_fetched.person);
                              if(rich_mapper.get(person_fetched.person) != null){
                                for(int per : rich_mapper.get(person_fetched.person)){
                                    //System.out.println(i + " : "+ person + " : "+per);
                                    if(!seen.contains(per)){
                                        State per_child = new State(per,per);
                                        stack.push(per_child);
                                    }
                                }
                                        
                            }else{
                                  //add to the result dictionary if it doesn't have any children
                                 res_mapper.put(person_fetched.person,person_fetched.person);  
                            }
                          }else{
                                State curr_person = stack.pop();
                               
                                if(quiet[curr_person.least_loud] < quiet[least_quite]){
                                    least_quite = curr_person.least_loud;
                                }
                              //if it hasn't been registered then add it to the result dictionary
                                if(!res_mapper.containsKey(curr_person.person)){
                                    res_mapper.put(curr_person.person,least_quite);
                                }
                                
                        }
                    }
                    
                }
                        
                
                //put the least quite person 
                //System.out.println(i + " : "+least_quite);
                res[i] = least_quite;
                //break;
        }
        
        return res;
    }
}
class State{
    int person;
    int least_loud;
    public State(int per,int loudness){
        person = per;
        least_loud = loudness;
    }
    
    @Override
    public int hashCode() {
        String hash = "" + person + " " + least_loud;
        return hash.hashCode();
    }
    
    @Override
    public boolean equals(Object o){
        State newState = (State) o;
        return this.person == newState.person && this.least_loud == newState.least_loud;
    }
}
//Custom stack
class CStack{
    ArrayList<State> stack;
    public CStack(){
        stack = new ArrayList<State>();
    }
    public State pop(){
        State num = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return num;
    }
    public void push(State c){
        stack.add(c);
    }
    public State peek(){
        State num = stack.get(stack.size() - 1);
        return num;
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public void addFirst(State num){
        
    }
}