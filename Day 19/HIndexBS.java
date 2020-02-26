//https://leetcode.com/problems/h-index-ii/
class HIndexBS {
    public int hIndex(int[] citations) {
        int h_index = 0;
        int big_num_counter = 0;
        int left = 0;
        int right = citations.length-1;
      
        while(left <= right){
            int mid = left + ((right - left)/2);
            if(citations[mid] <= citations.length - mid){
                h_index = citations[mid];
                left = mid+1;
            }else{
                big_num_counter = citations.length - mid;//get the count of big numbers after the middle value
                right = mid-1;
            }
        }
        //check the count of big numbers
        if(big_num_counter > h_index){
            h_index = big_num_counter;
        }
        
        return h_index;     

   
    }
}