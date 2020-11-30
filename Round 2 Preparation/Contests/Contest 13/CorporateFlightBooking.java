//https://leetcode.com/contest/weekly-contest-144/problems/corporate-flight-bookings/
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flightsBooked = new int[n];
        int[] endTracker = new int[n];
        for(int index = 0; index < bookings.length; index++){
            int start = bookings[index][0];
            int end = bookings[index][1];
            int flightCount = bookings[index][2];
            //putting the starting point for increasing
            endTracker[start-1] += flightCount;
            if(end < n){
             //putting the ending point for increasing
             endTracker[end] -= flightCount;
            }
        }
        int tempSum = 0;
        for(int index = 0; index < endTracker.length; index++){
            tempSum += endTracker[index];
            flightsBooked[index] = tempSum;           
        }
        return flightsBooked;
    }
}