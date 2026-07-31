class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 1;
        int r = k;
        int max = Integer.MIN_VALUE;

        int[] res = new int[nums.length - k + 1];

        for(int i = 0; i<k; i++)
        {
            max = Math.max(max, nums[i]);
        }

        int i = 0;
        res[i++] = max;

        while(r<nums.length)
        {
            if(nums[r] >= max)
            {
                max = nums[r];
                res[i++] = max;
                r++;
                l++;
            }
            else
            {
                max = findMax(l,r,nums);
                res[i++] = max;
                l++;
                r++;
            }
        }

        return res;
    }

    private int findMax(int l, int r, int[] nums)
    {
        int max = Integer.MIN_VALUE;

        while(l<=r)
        {
            max = Math.max(nums[l], max);
            l++;
        }

        return max;

    }
}
