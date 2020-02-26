//https://leetcode.com/problems/sort-colors/
class ColorSort {
    public void sortColors(int[] nums) {
        for(int i=1; i< nums.length; i++){
            int counter = i;
            while(counter > 0){
                if(nums[counter] < nums[counter-1]){
                    int temp = nums[counter - 1];
                    nums[counter-1] = nums[counter];
                    nums[counter] = temp;
                    counter--;
                }else{
                    break;
                }
            }
        }
    }
    public static void main(String args[]){
        // int[] list = {2,0,2,1,1,0};
        // sortColors(list);

    }
}