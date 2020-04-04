public class SingleNumberII{
    public int getSingleNumber(int[] nums){
        int shift = 0;
        int number = 0;
        while(shift < 32){
            int oneCounter = 0;
            for(int num: nums){
                if((num &( 1 << shift)) != 0){
                    oneCounter++;
                }
            }
            if(oneCounter % 3 != 0){
                number = number | (1 << shift);
            }
            shift++;
        }
        return number;
    }
}