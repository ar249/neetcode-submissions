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
            int mida = low + (high - low)/2;
            int midb = ((m+n+1)/2)-mida;

            int al = (mida == 0) ? Integer.MIN_VALUE : nums1[mida-1];
            int ar = (mida == m) ? Integer.MAX_VALUE : nums1[mida];
            int bl = (midb == 0) ? Integer.MIN_VALUE : nums2[midb-1];
            int br = (midb == n) ? Integer.MAX_VALUE : nums2[midb];

            if(al<=br && bl<=ar)
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
                high = mida-1;
            }
            else
            {
                low = mida+1;
            }
        }
        return 0.0;
    }
}
