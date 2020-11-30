//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] leftSum = new int[k+1];
        int[] rightSum = new int[k+1];
        int maxSc = 0;
        for(int index = 0; index < k; index++){
            leftSum[index+1] = cardPoints[index] + leftSum[index];           
        }
        for(int index = 0; index < k; index++){
            int rightMost = k - index - 1;
            int pointerRight = cardPoints.length - index -1;
            rightSum[rightMost] = cardPoints[pointerRight] + rightSum[rightMost+1];
        }
        for(int index = 0; index < leftSum.length; index++){
            maxSc = Math.max(maxSc,leftSum[index]+rightSum[index]);
        }
        
        return maxSc;
    }
}