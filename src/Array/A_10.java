class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        
        int[] merged = new int[len];
        
        int i=0, j=0, k=0;
        
        while(i < nums1.length & j < nums2.length){
            if(nums1[i] < nums2[j]){
                merged[k++] = nums1[i++];
            } else{
                merged[k++] = nums2[j++];
            }
        }
        while(i < nums1.length){
             merged[k++] = nums1[i++];
        }
        while(j < nums2.length){
              merged[k++] = nums2[j++];
        }
        double median = 0.0;
        int mid = merged.length/2;
        
        if(merged.length % 2 == 1){
            median = merged[mid];
        } else{
            median = (merged[mid] + merged[mid-1])/2.0;
        }
        return median;
    }
}
