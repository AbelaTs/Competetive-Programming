import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    public static String solution(String[] A) {
        // providing multi dimensional array to store occurance of each room
        HashMap<String, Integer> occuranceMapper = new HashMap<String, Integer>();
        int max = 0;
        String maxOccuredRoom = "";
        for (String room : A) {
            if (room.startsWith("+")) {
                if (occuranceMapper.containsKey(room)) {
                    occuranceMapper.put(room, occuranceMapper.get(room) + 1);
                } else {
                    occuranceMapper.put(room, 1);
                }
                if (occuranceMapper.get(room) > max) {
                    max = occuranceMapper.get(room);
                    maxOccuredRoom = room;
                } else if (occuranceMapper.get(room) == max) {
                    if (maxOccuredRoom.compareTo(room) > 0) {
                        maxOccuredRoom = room;
                    }
                }
            }
        }
        return maxOccuredRoom.substring(1,maxOccuredRoom.length());
    }

}
