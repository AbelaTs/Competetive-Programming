import java.util.HashMap;

class NumberLongestIncreasing {
    public int findNumberOfLIS(int[] nums) {
        HashMap<Integer,Integer> mapper = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> res_counter = new HashMap<Integer,Integer>();
        int[] res_mapper = new int[nums.length];
        int max_counter = 1;
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        if(nums.length >= 2){
            mapper.put(nums.length-1,1);
            res_mapper[res_mapper.length-1] = 1;
            for(int i = nums.length -2; i >= 0; i--){
                int counter = 0;
                for(int j = nums.length - 1; j > i; j--){
                    if(nums[j] > nums[i]){
                        if(mapper.get(j) > counter){
                            counter = mapper.get(j);
                        }
                    }
                }
                mapper.put(i,counter+1);
                res_mapper[i] = counter+1;
                //track the count of longest sequences
                if(counter+1 > max_counter){
                    //System.out.println(i + " : "+(counter+1));
                    max_counter = counter+1;
                    
                }
            }
            
        }
        int final_counter = 0;
        res_counter.put(nums.length-1,1);
        //System.out.println(max_counter);
        for(int i = nums.length-2; i >= 0; i--){
           res_counter.put(i,0);
           for(int j = i+1; j < nums.length; j++){
               if(nums[j] > nums[i]){
                   if(res_mapper[i]-1 == res_mapper[j]){
                       res_counter.put(i,res_counter.get(i) + res_counter.get(j));
                   }
               }
           }
           if(res_counter.get(i) == 0){
               res_counter.put(i,1);
           }
            //System.out.println(res_counter.get(i+","+res_mapper[i]) + " : " + i+","+res_mapper[i]);
        }
        
        for(int i = 0; i < res_mapper.length; i++){
            if(res_mapper[i] == max_counter){
                final_counter += res_counter.get(i);
            }
        }
            
        
        return final_counter;
        
    }
}