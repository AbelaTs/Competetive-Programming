class Solution {

    int[] cache;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        cache = new int[target + 1];
        Arrays.fill(cache, -1);
        
        
        return findCombination(nums, target);
    }
    
    private int findCombination(int[] nums, int target){
        if(target ==  0) return 1;
        
        if(cache[target] != -1) return cache[target];
        
        
        int count = 0;
        for(int num : nums){
            if(target - num < 0) 
                break;
            count += findCombination(nums, target - num);
        }

        cache[target] = count;
        
        return count;
    }
}
