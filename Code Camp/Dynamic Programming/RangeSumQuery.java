//https://leetcode.com/problems/range-sum-query-immutable/
import java.util.ArrayList;

class RangeSumQuery {
    ArrayList<Integer> number_list;
    public RangeSumQuery(int[] nums) {
        number_list = new ArrayList<Integer>();
        for(int num : nums){
            number_list.add(num);
        }
    }
    
    public int sumRange(int i, int j) {
        int sum = 0;
        if(i >=0 && j < number_list.size()){
            for(int index = i; index < j+1; index++){
                sum += number_list.get(index);
            }
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */