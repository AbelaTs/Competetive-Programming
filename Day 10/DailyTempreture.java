//https://leetcode.com/problems/daily-temperatures
public class DailyTempreture {
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        int counter;
        for(int x =0; x<T.length; x++){
            counter = 0;
            for(int y = x+1; y<T.length; y++){
                if(T[y] > T[x]){
                    counter++;
                    result[x] = counter;
                    break;
                }
                counter++;
            }
            if(Integer.toString(result[x]).length() < 1){
                result[x] = 0;
            }

        }
        return result;
    }
    public static void main(String args[]){
      

    }
}