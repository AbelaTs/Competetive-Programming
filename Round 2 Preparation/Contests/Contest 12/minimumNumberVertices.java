class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] vertices = new int[n];
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int index = 0; index < edges.size(); index++){
            vertices[edges.get(index).get(1)]++;
        }
        //
        for(int index = 0; index < n; index++){
            if(vertices[index] == 0){
                result.add(index);
            }
        }
        return result;
        
    }
}