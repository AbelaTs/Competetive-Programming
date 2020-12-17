//https://leetcode.com/problems/search-in-rotated-sorted-array/
class SearchInRotatedSortedArray{
    public int search(int[] list,int target){
        int start = 0;
        int end = list.length;
        while(start <= end){
            int mid = (start + end + 1)/2;
            if(list[mid] == target){
                return mid;
            }else if(target > list[mid]){
                if(list[start] > target && list[mid] >= list[end]){
                    start = mid+1;
                }else{
                    end = mid - 1;
                }
            }else{
                if(list[end] < target && list[mid] <= list[start]){
                    end = mid - 1;
                }else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}