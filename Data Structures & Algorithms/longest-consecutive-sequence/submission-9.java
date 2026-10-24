class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i : nums)
        {
            set.add(i);
        }

        int res = 0;

        for(int i : set)
        {
            int count = 0;
            if(!set.contains(i-1))
            {
                count++;
                while(set.contains(i+1))
                {
                    i = i+1;
                    count++;
                }

                res = Math.max(res, count);
            }
        }

        return res;
    }
}
