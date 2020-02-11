class UniqueBinaryTreeNo {
    public int numTrees(int n) {
        //stores number of unique binary tree for each n starting from 1
        int[] unique_val = new int[n+1];
        //base cases
        if(n == 1){
            unique_val[1] = 1;
        }else if( n >= 2){
            unique_val[2] = 2;
            unique_val[1] = 1;
        }
        //Temporary storage to calculate the number of unique binary trees
        int[] node = new int[n+1];
        
        int total_sum = 0;
        for(int i = 3; i < node.length; i++){
            int sum = 0;
            //calculate the number of unique binary trees up to the specific index
            for(int j = 1; j <= i; j++){
               int left = j - 1;
               int right = i - j;
               if(left != 0 && right != 0){
                   //System.out.println(unique_val[left] + " : " + unique_val[right]);
                   sum += unique_val[left] * unique_val[right];
               }else if(left != 0){
                   sum += unique_val[left];
               }else{
                   sum += unique_val[right];
               }
                  
            }
            //store the number of nunique binary trees for specific n so that we can memorize it later
            unique_val[i] = sum;
        }
        
        return unique_val[n];
    }
}