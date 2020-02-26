//https://leetcode.com/problems/number-of-recent-calls/
import java.util.ArrayList;
class   NumRecentCalls {
    static ArrayList<Integer> time_units;
    public NumRecentCalls() {
        time_units = new ArrayList<Integer>();
    }
    
    public static int ping(int t) {
        int counter = 0;
        time_units.add(t);
        for(int i = 0; i < time_units.size(); i++){
            if(time_units.get(i) >= t - 3000 && time_units.get(i) <= t){
                counter++;
            }
        }
        return counter;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */