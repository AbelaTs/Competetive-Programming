//http://codeforces.com/problemset/problem/1/A
import java.util.Scanner;
public class TheatreSquare{
    static Long width_num = 0L;
    static Long height_num = 0L;
    static Long square_num = 0L;

    public static void calculate(Long n,Long m,Long a){
        
        if (n%a == 0) {
            width_num = n/a;
        }else{
            width_num = n/a + 1;
        }
        if (m%a == 0){
            height_num = m/a;
        }else{
            height_num = m/a +1;
        }
        square_num = height_num*width_num;
        System.out.println(square_num);  
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
            Long n = scanner.nextLong();
            Long m = scanner.nextLong();
            Long a = scanner.nextLong();
            calculate(n, m, a);
            
    }
}