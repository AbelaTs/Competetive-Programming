import java.util.Scanner;

public class ErazeZeros{
    public static int removeZeros(String s){
        boolean started = false;
        int counter = 0;
        int zero_counter = 0;
        for(int i = 0; i < s.length(); i++){
            if(!started && s.charAt(i) == '1'){
                started = true;
            }
            if(started && s.charAt(i) == '0'){
                zero_counter++;
            }
            if(started && s.charAt(i) == '1'){
                counter += zero_counter;
                zero_counter = 0;
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterator = scanner.nextInt();
        scanner.nextLine();
        int[] res = new int[iterator];
        int counter = 0;
        while(iterator > 0){
            //System.out.println(iterator);
            String user_input = scanner.nextLine();
            int result = removeZeros(user_input);
            res[counter] = result;
            iterator--;
            counter++;
        }
        for(int i = 0; i <res.length; i++){
            System.out.println(res[i]);
        }
        
    }
}