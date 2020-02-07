class MaximumLengthPair {
    public int findLongestChain(int[][] pairs) {
         sort(pairs);
         pairs[0][0] = 1;
         int max_chain = 1;
         for(int i = 1; i < pairs.length; i++){
             int max = 0;
             for(int j = i-1; j >= 0; j--){
                 if(pairs[i][0] > pairs[j][1]){
                    if(pairs[j][0] > max){
                        max = pairs[j][0];
                    }
                 }
             }
             pairs[i][0] = max+1;
         }
        for(int i = 0; i < pairs.length; i++){
            if(pairs[i][0] > max_chain){
                max_chain = pairs[i][0];
            }
        }
        return max_chain;
    }
     //Sorts a given list
    public static void sort(int[][] list){
        int[] temp_holder;
        for(int index = 1; index < list.length;index++){
            int counter = index;
            while(counter > 0){
                if(list[counter][0]<list[counter-1][0]){
                    temp_holder = list[counter-1];
                    list[counter-1] = list[counter];
                    list[counter] = temp_holder;
                    counter--;
                }else{
                    break;
                }
            }
        }
       
    }
 
   
}