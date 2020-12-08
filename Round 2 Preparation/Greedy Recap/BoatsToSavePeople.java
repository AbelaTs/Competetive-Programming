//https://leetcode.com/problems/boats-to-save-people/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int leftPointer = 0;
        int rightPointer = people.length-1;
        int roundCounter = 0;
        while(leftPointer <=  rightPointer){
            if(people[leftPointer] + people[rightPointer] <= limit){
                leftPointer++;
                rightPointer--;
            }else if(people[leftPointer] + people[rightPointer] > limit){
                rightPointer--;
            }
            roundCounter++;
        }
        return roundCounter;
    }
}