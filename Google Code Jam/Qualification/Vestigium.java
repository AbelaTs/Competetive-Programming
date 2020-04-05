import java.io.IOException;
import java.util.*;

public class Vestigium {
    public static String checkTrace(int[][] matrix, int caseNumber) {
        int rowCount = 0;
        int colCount = 0;
        int trace = 0;
        // row check
        for (int row = 0; row < matrix.length; row++) {
            HashSet<Integer> numList = new HashSet<Integer>();
            for (int col = 0; col < matrix[row].length; col++) {
                numList.add(matrix[row][col]);
            }
            if (numList.size() != matrix.length) {
                rowCount++;
            }

        }
        // column check
        for (int col = 0; col < matrix.length; col++) {
            HashSet<Integer> numList = new HashSet<Integer>();
            for (int row = 0; row < matrix.length; row++) {
                numList.add(matrix[row][col]);
            }
            if (numList.size() != matrix.length) {
                colCount++;
            }

        }
        // calculating trace
        for (int row = 0; row < matrix.length; row++) {
            trace += matrix[row][row];
        }

        return "Case #" + (caseNumber+1) + ": " + trace + " " + rowCount + " " + colCount;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numTasteCase = scanner.nextInt();
        String result = "";
        int testCaseCounter = 0;
        while(numTasteCase > 0){
            int matrixSize = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[][] s = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                String[] sRowItems = scanner.nextLine().split(" ");
                for (int j = 0; j < sRowItems.length; j++) {
                    int sItem = Integer.parseInt(sRowItems[j]);
                    s[i][j] = sItem;
                }
            }
            result = result + checkTrace(s,testCaseCounter) + "\n";
            numTasteCase--;
            testCaseCounter++;
        }
        System.out.println(result);
    }
}