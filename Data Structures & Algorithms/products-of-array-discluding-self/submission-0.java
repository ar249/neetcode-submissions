class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pre = 1;
        int post = 1;
        int[] preArray = new int[nums.length];
        int[] postArray = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            preArray[i] = pre;
            pre *= nums[i];
        }

        for(int j = nums.length - 1; j>=0; j--)
        {
            postArray[j] = post;
            post *= nums[j];
        }

        for(int i =0; i<nums.length; i++)
        {
            nums[i] = preArray[i] * postArray[i];
        }

        return nums;

    }
}  
