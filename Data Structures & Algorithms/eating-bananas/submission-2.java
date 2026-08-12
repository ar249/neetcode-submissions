class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        int res = 0;

        for(int p : piles)
        {
            r = Math.max(r, p);
        }

        while(l<=r)
        {
            int mid = l + (r-l)/2;

            int tt = 0;
            for(int i : piles)
            {
                tt += (i + mid-1)/mid;
            }

            if(tt <= h)
            {
                res = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return res;


    }
}
