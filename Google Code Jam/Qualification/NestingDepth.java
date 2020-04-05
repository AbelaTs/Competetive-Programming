import java.util.Scanner;

public class NestingDepth {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTasteCase = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String result = "";
        int testCaseCounter = 0;
        while(numTasteCase > 0){
            String[] sRowItems = scanner.nextLine().split("");
            int[] s = new int[sRowItems.length];
            for (int i = 0; i < sRowItems.length; i++) {
                    int sItem = Integer.parseInt(sRowItems[i]);
                    s[i] = sItem;
                }
            result = result + validateParenthesis(s,testCaseCounter) + "\n";
            numTasteCase--;
            testCaseCounter++;
        }
        System.out.println(result);
    }

    public static String validateParenthesis(int[] nums,int tasteCaseNum){
        String result = "";
        int inProcess = 0;
        for (int num: nums) {
            if(inProcess < num){
                for (int i = inProcess; i < num; i++) {
                    result += "(";
                    inProcess++;
                }
            }else if(inProcess > num){
                int remaining = inProcess - num;
                for (int i = 0; i < remaining ; i++) {
                    result += ")";
                    inProcess--;
                }
            }
            result += num;
        }
        for (int i = 0; i < inProcess; i++) {
            result += ")";
        }

        return "Case #" + (tasteCaseNum+1) + ": " +result;
    }
}