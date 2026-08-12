class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for(int i : piles)
        {
            r = Math.max(r, i);
        }

        int res = 0; 

        while(l<=r)
        {
            int mid = l + (r-l)/2;

            long th = 0;
            for(int pile : piles)
            {
               th += (pile + mid - 1) / mid;
            }

            if(th <= h)
            {
               res = mid;
               r = mid-1;
            }
            else
            {
                l = mid+1;
            }
        }

        return res;
    }
}
