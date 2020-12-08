//https://leetcode.com/contest/weekly-contest-123/problems/add-to-array-form-of-integer/
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        String numString = Integer.toString(K);
        int[] kList = new int[numString.length()];
        for(int index = 0; index < numString.length(); index++){
            kList[index] = numString.charAt(index) - '0';
        }
        //System.out.println(Arrays.toString(kList));
        if(kList.length >= A.length){
            return sum(kList,A);
        }
        return sum(A,kList);
    }
    public List<Integer> sum(int[] num1, int[] num2){
        List<Integer> sumList = new ArrayList<>();
        int carry = 0;
        int counter = 0;
        for(int index = 0;index < num1.length; index++){
            int num2Index = num2.length-1 - index;
            int num1Index = num1.length-1 - index;
            if(num2Index >= 0){
                int tempSum = num1[num1Index] + num2[num2Index] + carry;
                if(tempSum > 9){
                    tempSum = tempSum - 10;
                    carry = 1;
                }else{
                    carry = 0;
                }
                sumList.add(tempSum);
            }else{
                int tempSum = num1[num1Index] + carry;
                if(tempSum > 9){
                    tempSum = tempSum - 10;
                    carry = 1;
                }else{
                    carry = 0;
                }
                sumList.add(tempSum);
            }
            counter++;
        }
        if(carry == 1){
            sumList.add(carry);
        }
        Collections.reverse(sumList);
        return sumList;
    }
}