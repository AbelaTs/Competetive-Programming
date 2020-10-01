//https://www.hackerrank.com/challenges/recursive-digit-sum/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
        String stringSum = "";
        HashMap<String,Integer> visited = new HashMap<String,Integer>();
        int sum = 0;
        while(k > 0){
            sum += recursiveSum(n,visited);
            k--;
        }
        if(Integer.toString(sum).length() > 1){
            return recursiveSum(Integer.toString(sum),visited);
        }
        return sum;
        
    }
    static int recursiveSum(String num, HashMap<String,Integer> visited){
        if(visited.containsKey(num)){
            return (int) visited.get(num);
        }
        if(num.length() == 1){
            return Integer.parseInt(num);
        }
        int sum = 0;
        for(int index = 0; index <  num.length(); index++){
            sum += Integer.parseInt(String.valueOf(num.charAt(index)));
        }
        visited.put(num,recursiveSum(Integer.toString(sum),visited));
        return visited.get(num);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
