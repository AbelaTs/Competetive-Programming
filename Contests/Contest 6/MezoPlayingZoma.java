//https://codeforces.com/contest/1285/problem/A
import java.util.Scanner;
public class MezoPlayingZoma{
    public static int get_positions(String input){
        int[] combination = new int[input.length()];
        int smallest_range = 0;
        int largest_range = 0;
        int positions = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'L'){
               smallest_range--;
            }else if(input.charAt(i) == 'R'){
               largest_range++;
            }
        }
        for(int i = smallest_range; i <= largest_range; i++){
            positions++;
        }
        return positions;
    
    }
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        System.out.println(get_positions(input));
    }
}