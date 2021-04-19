//https://leetcode.com/problems/minimum-sideway-jumps/
class Solution {
    public int minSideJumps(int[] obstacles) {
        int lane = 2;
        int minimum = 0;
        boolean laneChoosing = false;

        for (int index = 1; index < obstacles.length - 1; ++index) {
            int obstacle = obstacles[index];
            if (obstacle == 0) {
                continue;
            }
            if (laneChoosing && obstacle != lane) {
                laneChoosing = false;
                lane = obstacle ^ lane;
            } else if (!laneChoosing && obstacle == lane) {
                int prevObstacle = obstacles[index - 1];
                if (prevObstacle != 0) {
                    lane = prevObstacle ^ lane;
                } else {
                    laneChoosing = true;
                }
                minimum++;
            }
        }

        return minimum;
    }
}
