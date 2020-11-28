//https://leetcode.com/problems/combination-sum/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        getCombinations(candidates,candidates.length - 1,target,result,new ArrayList<Integer>());
        return result;
        
    }
    public void getCombinations(int[] candidates,int startIndex,int target,List<List<Integer>> result, ArrayList<Integer> tempRes){
        if(target == 0){
            ArrayList<Integer> temporaryMem = new ArrayList<>();
            for(int index = 0; index < tempRes.size(); index++){
                temporaryMem.add(tempRes.get(index));
            }
            result.add(temporaryMem);
            return;
        }
        if(target < candidates[0]){
            return;
        }
        for(int index = startIndex; index >= 0; index--){
            if(target >= candidates[index]){
                int tempTarget = target - candidates[index];
                tempRes.add(candidates[index]);
                getCombinations(candidates,index,tempTarget,result,tempRes);
                tempRes.remove(new Integer(candidates[index]));
            }
        }
        
    }
}