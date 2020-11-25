public class Solution {
    public int countLargestGroup(int n) {
         int[] countMemory= new int[n+1];
         int[] map = new int[37];
         int maxSize=0, maxCount=0;

         for (int i=1;i<=n;i++){
             countMemory[i]=countMemory[i/10]+i%10;
             map[countMemory[i]]++;
         }

         for (int i: map){
             maxSize=Math.max(maxSize,i);
         }
         for (int i: map){
             if (maxSize==i) maxCount++;
         }

         return maxCount;
    }
}