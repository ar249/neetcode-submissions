class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pre = 1;
        int post = 1;

        // int[] left = new int[nums.length];
        // int[] right = new int[nums.length];
        int res[] = new int[nums.length];

        for(int i = 0; i < nums.length; i++)
        {
            // left[i] = pre;
            res[i] = pre;
            pre *= nums[i];
        }

        for(int j = nums.length - 1; j>=0; j--)
        {
            // right[j] = post;
            res[j] *= post;
            post *= nums[j];
        }

        // for(int i =0; i<nums.length; i++)
        // {
        //      res[i] = left[i] * right[i];
        // }

        return res;

    }
}  
