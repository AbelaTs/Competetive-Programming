//https://leetcode.com/problems/median-of-two-sorted-arrays/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length+1;
        int half = (totalSize)/2;
        //making sure first array is smaller than the next one
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int left = 0;
        int right = nums1.length;
        //System.out.println(nums1[0]);
        while(left <= right){
            int nums1Mid = (left + right)/2;
            int nums2Mid = half - (nums1Mid);
            if(nums1Mid > left &&  nums1[nums1Mid-1] > nums2[nums2Mid]){
                right = nums1Mid-1;
            }else if(nums1Mid < right && nums2[nums2Mid-1] > nums1[nums1Mid]){
                left = nums1Mid+1;//move to the left
            }else{
                //if two half are equal and median is found
                double leftMax = 0.0;
                if(nums1Mid == 0){
                    leftMax = (double) nums2[nums2Mid - 1];
                }else if(nums2Mid == 0){
                    leftMax = (double) nums1[nums1Mid-1];
                }else{
                    leftMax = (double) Math.max(nums1[nums1Mid-1],nums2[nums2Mid-1]);
                }
                //if total length of the two arrays is odd
                if((nums1.length+nums2.length) % 2 != 0){
                    return leftMax;
                }
                double rightMax = 0.0;
                if(nums1Mid == nums1.length){
                    rightMax = nums2[nums2Mid]; 
                }else if(nums2Mid == nums2.length){
                    rightMax = nums1[nums1Mid];
                }else{
                    rightMax = (double) Math.min(nums1[nums1Mid],nums2[nums2Mid]);
                }
                return (leftMax + rightMax)/2.0;
                
            }
            
        }
        return -1.0;
    }
}