import java.util.Scanner;
public class TheatreSquare{
    static Long total_width = new Long(0);
    static Long total_height = new Long(0);
    static Long numb_break_wid = new Long(0);
    static Long numb_break_hight = new Long(0);
    static Long total_num_breaks = new Long(0);

    public static Long calculate(Long n,Long m,Long a){
        
        while(true){
            if(total_width >= n ){
                break;
            }
            total_width += a;
            
            numb_break_wid+=1;
        }
        
        while(true){
            if(total_height >= m){
                break;
            }
            total_height += a;
            
            numb_break_hight+=1;
        }
        total_num_breaks = numb_break_hight*numb_break_wid;
        return total_num_breaks;
    
        
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
            Long num1 = scanner.nextLong();
            Scanner scanner2 = new Scanner(System.in);
            Long num2 = scanner2.nextLong();
            Scanner scanner3 = new Scanner(System.in);
            Long num3 = scanner3.nextLong();
            System.out.println(calculate(num1,num2,num3));
    }
}