//https://leetcode.com/problems/merge-intervals/
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        Arrays.sort(intervals, (a, b) -> Double.compare(a[0], b[0]));
        
        if(intervals.length > 0){
            result.add(intervals[0]);
            if(intervals.length > 1){
                for(int index = 0; index < intervals.length; index++){
                    if(intervals[index][0] <= result.get(result.size()-1)[1]){
                        if(intervals[index][1] > result.get(result.size()-1)[1]){
                        intervals[index][0] =result.get(result.size()-1)[0];
                            result.set(result.size()-1,intervals[index]);
                        }
                        
                    }else{
                        result.add(intervals[index]);
                    }
                }
            }
        }
        int[][] finalResult = new int[result.size()][2];
        for(int index = 0; index < result.size(); index++){
            finalResult[index] = result.get(index);
        }
        return finalResult;
        
    }
}