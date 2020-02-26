//https://leetcode.com/problems/monotonic-array/
class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        String seq = "";
        boolean isMono = true;
        if(A.length > 2){
            if(A[1] < A[0]){
                seq = "l";
            }else if(A[1] > A[0]){
                seq = "g";
            }else{
                seq = "e";
            }
            for(int i = 2; i < A.length; i++){
                if(seq.equals("e")){
                    if(A[i] < A[i-1]){
                        seq = "l";
                    }else if(A[i] > A[i-1]){
                        seq = "g";
                    }
                }else{
                    if(seq.equals("l")){
                        if(A[i] > A[i-1]){
                            return false;
                        }
                    }else{
                        if(A[i] < A[i-1]){
                            return false;
                        }
                    }
                }
            }
        }
        
        return isMono;
        
    }
}