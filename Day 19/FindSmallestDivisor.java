class FindSmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int smallest_devisor = 0;
        int right = 1000000;
        while(left <= right){
            int mid = left +((right - left)/2);
            int sum = 0;
            
            for(int i = 0; i < nums.length; i++){
                double quotient = Double.valueOf(nums[i])/Double.valueOf(mid);
                if(Math.floor(quotient) != quotient){
                    
                    quotient = Math.ceil(quotient);
                }
                
                sum += quotient;
             
            }
            //check for the sum
            if(sum > threshold){
                left = mid+1;
            }else if(sum <= threshold){  
                smallest_devisor = mid;
                right = mid - 1;
            }
        
           
        }
         return smallest_devisor;
        
    }
}