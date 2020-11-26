class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashSet<Integer> seen = new HashSet<>();
        HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<>();
        //build the adjecency list
        for(int index = 0; index < edges.length; index++){
            if(adjList.containsKey(edges[index][0])){
                adjList.get(edges[index][0]).add(edges[index][1]);
            }else{
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(edges[index][1]);
                adjList.put(edges[index][0],newList);
            }
            
            
            if(adjList.containsKey(edges[index][1])){
                adjList.get(edges[index][1]).add(edges[index][0]);
            }else{
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(edges[index][0]);
                adjList.put(edges[index][1],newList);
            }
        }
        
        
        //going DFS
        int[] minTime = new int[]{0};
        doDfs(adjList,seen,hasApple,minTime,0);
        return minTime[0];        
    }
    public int doDfs(HashMap<Integer,ArrayList<Integer>> edges, HashSet<Integer> seen, List<Boolean> hasApple, int[] minTime, int node) {
        if(!edges.containsKey(node)){
            return hasApple.get(node) ? 1 :0;
            
        }
        int temp = 0;
        for(int vertex : edges.get(node)){
            if(!seen.contains(vertex)){
                 seen.add(node);
                temp += doDfs(edges,seen,hasApple,minTime,vertex);
               
            }
            
        }
        minTime[0] += temp*2;
        return hasApple.get(node) || temp > 0 ? 1 : 0;
    }
   
}