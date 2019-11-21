//Author : Abel Tsegaye
import java.util.Scanner;

public class CalculatorConsole {
    static double first_num;
    static double second_num;
    static String operator;
    static double result;
    
    public static double calculate(double f_num,double s_num,String oper){
        first_num = f_num;
        second_num = s_num;
        operator = oper;
        
         if (operator.equalsIgnoreCase("+")) {
            result = first_num + second_num;
            return result;
            
        }
        else if (operator.equalsIgnoreCase("-")) {
            result = first_num - second_num;
            return result;
        }
        else if (operator.equalsIgnoreCase("*")) {
            result = first_num * second_num;
            return result;
        }
        else if (operator.equalsIgnoreCase("/")) {
            result = (double)first_num / (double)second_num;
            return result;
        }
        else if (operator =="%") {
            result = first_num % second_num;
            return result;
        }
        return 0;
    }
    
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number :");
        double num1 = scanner.nextDouble();
        System.out.println("Enter which operation would you like to perform(+,-,/,*) :");
        String operation = scanner.next();
        System.out.println("Enter the second number :");
        double num2 = scanner.nextDouble();
        
        
        System.out.print("Result : ");
        System.out.println(Double.toString(calculate(num1,num2,operation)));
        
        
    }
    
}
