class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        int slow1 = nums[0];

        while(slow != slow1)
        {
            slow = nums[slow];
            slow1 = nums[slow1];
        }

        return slow;
    }
}
