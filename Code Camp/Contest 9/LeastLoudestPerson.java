import java.util.ArrayList;
import java.util.HashMap;

class LeastLoudestPerson {
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
            if(!res_mapper.containsKey(i)){
              int least_loud = findDfs(rich_mapper,res_mapper,quiet,i);
              res_mapper.put(i,least_loud);
              res[i] = least_loud;
            }else{
                res[i] = res_mapper.get(i);
            }
        }
        
        return res;
    }
    
        //DFS Function
        public int findDfs(HashMap<Integer,ArrayList<Integer>> Adjecency_list,HashMap<Integer,Integer> result_map,int[] quiet_list, int index){
        if(result_map.containsKey(index)){
            return result_map.get(index);
        }
        if(Adjecency_list.get(index) == null){
            return index;
        }
        int least_loudest = index;
        for(int child : Adjecency_list.get(index)){
            int per_index = findDfs(Adjecency_list,result_map,quiet_list,child);
            if(quiet_list[per_index] < quiet_list[least_loudest]){
                least_loudest = per_index;
            }
        }

        return least_loudest;

    }
}
