class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pre = 1;
        int post = 1;
        int res[] = new int[nums.length];

        for(int i = 0; i < nums.length; i++)
        {
            res[i] = pre;
            pre *= nums[i];
        }

        for(int j = nums.length - 1; j>=0; j--)
        {
            res[j] *= post;
            post *= nums[j];
        }

        return res;

    }
}  
