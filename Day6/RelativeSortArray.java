class Solution {
    public boolean search(int input,int[] arr2){
        for(int i=0; i<arr2.length;i++){
            if(arr2[i] == input){
                return true;
            }
        }
        return false;
    }
    
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap rep_counter = new HashMap<Integer,Integer>();
        int common_int = 0;
        
        for(int j =0; j<arr1.length; j++){
             if(rep_counter.containsKey(arr1[j])){
                int value =  (int) rep_counter.get(arr1[j]);
                rep_counter.put(arr1[j],value+1);
                   common_int++;
            }else{
                rep_counter.put(arr1[j],1);
             }
        }
        int[] result = new int[arr1.length];
      
        int unique_length = 0;
        int counter = 0;
       
        int result_counter = 0;
        int unique_counter = 0;
        int final_result_counter = 0;
        
        //Putting the common numbers first
        for(int i = 0;i<arr2.length;i++){
            int c = (int) rep_counter.get(arr2[i]);
             
            while( c >= 1){  
            result[result_counter] = arr2[i];
                c--;
                result_counter++;
            }    
        }
        //putting the uncommon numbers
        for(Object value : rep_counter.keySet()){
            int c = (int) rep_counter.get(value);
            int key = (int) value;
            
             if(!search(key,arr2) && c>=1)
             {  
                 while( c >= 1){  
                    result[result_counter] = key;
                    result_counter++;    
                    c--;
            }
                         
              }
        }
        
        //filtering out the total number of unique numbers 
        for (int i=0; i<result.length;i++){
            if(!search(result[i],arr2)){
                unique_length++;
            }
        }
         int[] unique_nums = new int[unique_length];
        //put the unique number to a saparate array
        for (int i=0; i<result.length;i++){
            if(!search(result[i],arr2)){
                 unique_nums[unique_counter] = result[i];
                unique_counter++;
            }
        }
        //Sort the array
        Arrays.sort(unique_nums);
        //Re add the common numbers numbers in their order to the final array
        
          for(int i = 0;i<arr2.length;i++){
            int c = (int) rep_counter.get(arr2[i]);
             
            while( c >= 1){  
            result[final_result_counter] = arr2[i];
                c--;
                final_result_counter++;
            }    
        }
        //Re add the sorted unique numbers
         for(int i=0; i< unique_nums.length;i++){
              result[final_result_counter] = unique_nums[i];
              final_result_counter++;
         }
        
        
       
        return result;
       
        
        
        
    }
}