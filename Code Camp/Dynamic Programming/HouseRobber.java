class HourseRobber {
    public int rob(int[] nums) {
       for(int i = 0; i < nums.length; i++){
           if(i - 2 >= 0){
               if(i-3 >= 0){
                   if(nums[i-3] > nums[i-2]){
                       nums[i] += nums[i-3];
                   }else{
                       nums[i] += nums[i-2];
                   }
               }else{
                    nums[i] += nums[i-2];
               }
           }
       }
       if(nums.length >= 2){
         return Math.max(nums[nums.length-1],nums[nums.length-2]);
       }else{
           if(nums.length == 1){
              return nums[0]; 
           }
         return 0;
       }
        
    }
}