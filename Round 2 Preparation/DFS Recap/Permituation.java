//https://leetcode.com/problems/permutations/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        
        permutate(nums,seen,new ArrayList<Integer>(),result);
        return result;
        
        
    }
    public void permutate(int[] nums,HashSet<Integer> seen,ArrayList<Integer> tempResult,List<List<Integer>> result){
        //if the length is equal with our original num length
        if(nums.length == tempResult.size()){
            //make a copy since the temp result it going to be manipulated again
            ArrayList<Integer> tempCopy = new ArrayList<>();
            for(int index = 0; index < tempResult.size(); index++){
                tempCopy.add(tempResult.get(index));
            }
            result.add(tempCopy);
            return;
        }
        //run dfs for each numbers
        for(int index = 0; index < nums.length; index++){
            if(!seen.contains(nums[index])){
                //add the number to the temp result if not seen
                tempResult.add(nums[index]);
                //add it to the seen
                seen.add(nums[index]);
                //go recursive
                permutate(nums,seen,tempResult,result);
                //remove from our temp result
                tempResult.remove(tempResult.size()-1);
                //remove from seen
                seen.remove(nums[index]);
            }
        }
        
    }
}