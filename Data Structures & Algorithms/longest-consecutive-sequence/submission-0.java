class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0)
        return 0;

        Set<Integer> set = new HashSet<>();

        for(int i : nums)
        {
            set.add(i);
        }

        int longest = 0;

        for(int i : set)
        {
            if(!set.contains(i-1))
            {
                int localLongest = 1;
                int temp = i;
                while(set.contains(temp+1))
                {
                    localLongest++;
                    temp++;
                }

                longest = Math.max(longest, localLongest);
            }
        }

        return longest;


    }
}
