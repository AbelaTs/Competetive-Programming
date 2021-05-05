//https://leetcode.com/problems/4sum-ii/
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        Map<Integer,Integer> mp = new HashMap<>();
        for (int i = 0;i < n; i++) {
            int x = nums1[i];
            for (int j = 0;j < n; j++) {
                int y = nums2[j];
                mp.put(x+y,mp.getOrDefault(x+y,0) + 1);
            }
        }
        int ans = 0;
        for (int i = 0;i < n; i++) {
            int w = nums3[i];
            for (int j = 0;j < n; j++) {
                int z = nums4[j];
                int target = -1 * (w+z);
                ans += mp.getOrDefault(target,0);
            }
        }
        return ans;
    }
}
