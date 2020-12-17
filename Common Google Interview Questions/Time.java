public class Time {
    public static String solution(String T) {
        String Time = "";

        // first hour digit
        if (T.charAt(0) == '?') {
            if (T.charAt(0 + 1) == '?' || T.charAt(0 + 1) - '0' >= 0 && T.charAt(0 + 1) - '0' < 4) {
                Time += "2";
            } else {
                Time += "1";
            }
        }
        // second hour digit
        if (T.charAt(1) == '?') {
            if (T.charAt(0) == '?' || T.charAt(0) - '0' == 2) {
                Time += "3";
            } else {
                Time += "9";
            }
        }
        Time += ":";
        // first minute digit
        if (T.charAt(3) == '?') {
            Time += "5";
        }
        // second minute digit
        if (T.charAt(3) == '?') {
            Time += "9";
        }

        return Time;
    }
}