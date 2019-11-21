import java.util.Scanner;
public class watermelon{
    public static int[] even_list;
    public static int counter = 0;
    public static String check(int weight){
        even_list = new int[weight];
        for(int i = 1; i<weight;i++){
            if(i%2 == 0){
                even_list[i] = i;
            }
            counter++;
        }
        for (int j=0; j<even_list.length;j++){
            for(int k=0; k<even_list.length;k++){
                if(even_list[j]+even_list[k] == weight){
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static void main(String args[]){
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();

            System.out.println(check(num));
    }
}   