class DeleteColumns {
    public int minDeletionSize(String[] A) {
        int counter = 0;
        String comparator = A[0];
        int index = 0;
        while(index < comparator.length()){
            int temp_store =(int) A[0].charAt(index);
            for(int i = 1; i < A.length; i++){
                if(temp_store  > (int) A[i].charAt(index)){
                    //System.out.println(A[i].charAt(index));
                    counter++;
                    break;
                }else{
                     temp_store = (int) A[i].charAt(index);
                }
            }
            index++;
        }
        return counter;
    }
}