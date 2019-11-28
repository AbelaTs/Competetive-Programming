class SortParityII{
    public int[] sortArrayByParityII(int[] A) {
        int[] odd = new int[A.length/2 + 1];
        int[] even = new int[A.length/2 +1];
        int even_counter = 0;
        int odd_counter = 0;
        int even_final_counter=0;
        int odd_final_counter=0;
        //Filtering out odds
        for(int i=0; i<A.length; i++){
            if(A[i] % 2 == 0){
                even[even_counter] = A[i];
                even_counter++;
            }else{
                odd[odd_counter] = A[i];
                odd_counter++;
            }
        }
        for(int j=0; j<A.length; j++){
            if(j % 2 == 0){
                A[j] = even[even_final_counter];
                even_final_counter++;
            }else{
                A[j] = odd[odd_final_counter];
                odd_final_counter++;
            }
        }
        return A;
        
    }
}