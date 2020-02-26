//https://leetcode.com/problems/min-cost-climbing-stairs/
class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int min_cost;
        for(int i = 2; i < cost.length; i++){
            cost[i] += Math.min(cost[i-1],cost[i-2]);
        }
        min_cost = Math.min(cost[cost.length -1],cost[cost.length - 2]);
        return min_cost;
    }
}