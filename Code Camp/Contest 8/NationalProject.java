//https://codeforces.com/contest/1303/problem/B
//Not finished
import java.util.Scanner;

public class NationalProject{
    public static long constructRoad(long road_length, long gd,long bd){
        long gd_needed = (long)Math.ceil((float)road_length/2);//good days needed to complete half
        System.out.println(gd_needed);
        long total_days = road_length;
        long complete_days = 0;
        if(gd_needed > gd){
            long gd_round = (int)Math.ceil((float)gd_needed/gd);
            long num_gd_days = gd_round * gd;//number of good days neeeded to complete half
            complete_days += num_gd_days;//first calculate the good days needed to complete half
            total_days -= num_gd_days;
            long bd_round = gd_round - 1;
            complete_days += (bd_round*bd);
            
            total_days -=  (bd_round*bd);
            if(total_days > 0){
                complete_days += total_days;
            }
            //System.out.println(complete_days);
            
        }else{
            complete_days = total_days;
        }
        return complete_days;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterator = scanner.nextInt();
        scanner.nextLine();
        long[] res = new long[iterator];
        int counter = 0;
        while(iterator > 0){
            //System.out.println(iterator);
            String user_input = scanner.nextLine();
            String[] get_input = user_input.split(" ");
            long result = constructRoad(Long.parseLong(get_input[0]),Long.parseLong(get_input[1]),Long.parseLong(get_input[2]));
            res[counter] = result;
            iterator--;
            counter++;
        }
        //int test = scanner.nextInt();
        for(int i = 0; i <res.length; i++){
            System.out.println(res[i]);
        }
    }
}