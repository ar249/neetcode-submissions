class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = 1;
        int n = nums.length;
        while(l < n-1)
        {
            int a = nums[l];
            for(int i = l+1; i<n; i++)
            {
                if(nums[i] + a == target)
                {
                    return new int[]{l, i};
                }
            }
            l++;
        }

        return new int[]{};
    }
}
