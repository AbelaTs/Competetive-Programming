//https://leetcode.com/problems/assign-cookies/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int childrenPointer = 0;
        int cookiePointer = 0;
        while(childrenPointer < g.length){
            if(cookiePointer < s.length){
                if(g[childrenPointer] > s[cookiePointer]){
                    cookiePointer++;
                }else{
                    childrenPointer++;
                    cookiePointer++;
                    contentChildren++;
                }
            }else{
                break;
            }
        }
        return contentChildren;
        
    }
}
