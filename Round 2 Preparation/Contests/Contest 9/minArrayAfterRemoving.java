//https://leetcode.com/contest/biweekly-contest-37/problems/mean-of-array-after-removing-some-elements/
class Solution {
    public double trimMean(int[] arr) {
            Arrays.sort(arr);
            int indexExtent = (arr.length * 5)/100;
            int startingIndex = 0 + indexExtent;
            int endingIndex = arr.length -indexExtent;
            int sum = 0;
            int totalMembers = 0;
            for(int index = startingIndex; index <  endingIndex; index++){
                sum += arr[index];
                totalMembers++;
            }
            return sum/(double)totalMembers;
        }
}

