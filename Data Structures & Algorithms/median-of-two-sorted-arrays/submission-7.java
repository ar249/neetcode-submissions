class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
        {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while(low<=high)
        {
            int mid1 = low + (high-low)/2;
            int mid2 = ((m+n+1)/2) - mid1;

            int al = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1-1];
            int ar = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];
            int bl = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2-1];
            int br = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];

            if(al <= br && bl <= ar)
            {
                if((m+n)%2 == 1)
                {
                    return Math.max(al, bl);
                }
                else
                {
                    return (Math.max(al, bl) + Math.min(ar, br))/2.0;
                }
            }
            else if(al > br)
            {
                high = mid1-1;
            }
            else
            {
                low = mid1+1;
            }
        }
        return 0.0;
    }
}