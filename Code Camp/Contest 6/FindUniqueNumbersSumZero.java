class FindUniqueNumbersSumZero {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        if(n % 2 == 0){
            int counter = 1;
            for(int i = 0; i < res.length; i+=2){
                res[i] = counter;
                res[i+1] = counter - (counter*2);
                counter++;
            }
        }else{
            int counter = 1;
            for(int i = 0; i < res.length-1; i+=2){
                res[i] = counter;
                res[i+1] = counter - (counter*2);
                counter++;
            }
            res[res.length-1] = 0;
        }
        return res;
    }
}