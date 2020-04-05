import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ParentingReturns {
    public static String schedule(int[][] list, int caseNumber, int size) {
        int[] listIntervalInfo = new int[size]; // 1 for Jamie and 2 for Cameron
        int[][] listWithIndex = new int[list.length][3];
        for (int index = 0; index < list.length; index++) {
            listWithIndex[index] = new int[] { index, list[index][0], list[index][1] };
        }
        Arrays.sort(listWithIndex, new ListComparator());
        int cameronEnd = 0;
        int jamieEnd = 0;

        for (int[] listInterval : listWithIndex) {
            if (jamieEnd <= listInterval[1]) {
                listIntervalInfo[listInterval[0]] = 1;
                jamieEnd = listInterval[2];
            } else if (cameronEnd <= listInterval[1]) {
                listIntervalInfo[listInterval[0]] = 2;
                cameronEnd = listInterval[2];
            } else {
                return "Case #" + (caseNumber + 1) + ": " + "IMPOSSIBLE";
            }

        }

        String result = "";
        for (int index : listIntervalInfo) {
            if (index == 1) {
                result += "C";
            } else {
                result += "J";
            }
        }
        return  "Case #" + (caseNumber + 1) + ": " +result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTasteCase = scanner.nextInt();
        String result = "";
        int testCaseCounter = 0;
        while (numTasteCase > 0) {
            int size = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[][] s = new int[size][2];

            for (int i = 0; i < size; i++) {
                String[] sRowItems = scanner.nextLine().split(" ");
                for (int j = 0; j < 2; j++) {
                    int sItem = Integer.parseInt(sRowItems[j]);
                    s[i][j] = sItem;
                }
            }
            result = result + schedule(s, testCaseCounter,size) + "\n";
            numTasteCase--;
            testCaseCounter++;
        }
        System.out.println(result);
    }

}

class ListComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] l1, int[] l2) {
        return l1[1] - l2[1];
    }
}