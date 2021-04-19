//https://leetcode.com/problems/finding-the-users-active-minutes/
class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
         HashMap<Integer,Set<Integer>> map=new HashMap<>();
        int result[]=new int[k];
        
        for(int log[]:logs){
          int logId=log[0];
          int time=log[1];
          if(map.containsKey(logId)){
            Set<Integer> timeSet=map.get(logId);
            timeSet.add(time);
          }
          else{
             Set<Integer> timeSet=new HashSet<>();
             timeSet.add(time);
            map.put(logId,timeSet);
          }
        }
      for(int logId:map.keySet()){
        int index=map.get(logId).size();
        result[index-1]++;
      }
      return result;
    }
}