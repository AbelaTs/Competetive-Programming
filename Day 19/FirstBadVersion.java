//https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion {
     int firstBad;
     int res = 1;
     
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + ((right-left)/ 2); //prevents overflow
            if(isBadVersion(mid)){
                if(!isBadVersion(mid-1)){
                    return mid;
                }
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        
        return res;
    }
    //Sample isBadVersion method from leetcode
    public boolean isBadVersion(int num){
        return false;
    }
}