//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
       int[][] DP = new int[s1.length()][s2.length()];
       int s1TotalAscii = 0;
       int s2TotalAscii = 0;
        //string 1
       for(int index = 0; index < s1.length(); index++){
           s1TotalAscii += (int) s1.charAt(index);
       }
        //calculating for strign 2
        for(int index = 0; index < s2.length(); index++){
            s2TotalAscii += (int) s2.charAt(index);
        }
        //calculating with dynamic programming grid
        for(int row = 0; row < DP.length; row++){
            for(int col = 0; col < DP[row].length; col++){
                if(s1.charAt(row) == s2.charAt(col)){
                    if(row -1 >= 0 && col - 1 >= 0){
                        DP[row][col] = (int) s1.charAt(row) + DP[row-1][col-1];
                    }else{
                        DP[row][col] = (int) s1.charAt(row);
                    }
                }else{
                    if(row -1 >= 0 && col - 1 >= 0){
                        DP[row][col] = Math.max(DP[row-1][col],DP[row][col-1]);
                    }else if(row - 1 >= 0 && DP[row-1][col] > 0){
                        DP[row][col] = DP[row-1][col];
                    }else if(col - 1 >= 0 && DP[row][col-1] > 0){
                        DP[row][col] = DP[row][col-1];
                    }else{
                        DP[row][col] = 0;
                    }
                }
            }
        }
        int maxAscii = DP[s1.length()-1][s2.length()-1];
        return s1TotalAscii + s2TotalAscii - (2*maxAscii);
    }
}