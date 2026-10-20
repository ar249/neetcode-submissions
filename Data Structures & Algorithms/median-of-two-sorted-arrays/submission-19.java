class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
        {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int l = 0;
        int r = m;

        while(l<=r)
        {
            int m1 = l + (r-l)/2;
            int m2 = (m+n+1)/2 - m1;

            int al = (m1 == 0) ? Integer.MIN_VALUE : nums1[m1-1];
            int ar = (m1 == m) ? Integer.MAX_VALUE : nums1[m1];
            int bl = (m2 == 0) ? Integer.MIN_VALUE : nums2[m2-1];
            int br = (m2 == n) ? Integer.MAX_VALUE : nums2[m2];

            if(al <= br && bl <= ar)
            {
                if((m + n)%2 == 0)
                {
                    return (Math.max(al, bl) + Math.min(ar, br))/2.0;
                }
                else
                {
                    return Math.max(al, bl);
                }
            }

            if(al > br)
            {
                r--;
            }
            else if(bl > ar)
            {
                l++;
            }
        }

        return 0.0;
    }
}
