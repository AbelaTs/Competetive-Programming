//Question : https://leetcode.com/problems/play-with-chips/submissions/
class PlayingChips {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0;
        int even = 0;
        for(int chip : chips){
            if(chip % 2== 0){
                even++;
                continue;
            }
            odd++;
        }
        return Math.min(odd,even);
    }
}