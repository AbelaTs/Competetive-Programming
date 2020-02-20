class LongestTurbulant {
    public int maxTurbulenceSize(int[] A) {
        if(A.length == 1){
            return 1;
        }
        Integer prev_state = 0;
        int max_counter = 1;
        int counter = 1;
        for(int i = 1; i < A.length; i++){
            //for the start counter is increased by 2
            if(counter == 1){
                if(A[i] > A[i - 1]){
                    //System.out.println(A[i] + " : " + A[i -1]);
                    counter += 1;
                    if(counter > max_counter){
                        max_counter = counter;
                    }
                    prev_state = 1;
                }else if(A[i] < A[i - 1]){
                    counter += 1;
                    if(counter > max_counter){
                        max_counter = counter;
                    }
                    prev_state = -1;
                }else{
                    counter = 1;
                }
            }else{
                //if previous is greater
                if(A[i] < A[i-1]){
                    if(prev_state == 1){
                        counter++;
                        if(counter > max_counter){
                            max_counter = counter;
                        }
                    }else{
                        counter = 2;
                    }
                    
                    prev_state = -1;
                }else if(A[i] > A[i - 1]){ // if previous is less 
                    if(prev_state == -1){
                        counter++;
                        if(counter > max_counter){
                            max_counter = counter;
                        }
                    }else{
                        counter = 2;
                        
                    }
                    prev_state = 1;
                }else{
                    counter = 1;
                }
            }
        }
        return max_counter;
    }
}