class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int n : nums)
        {
          set.add(n);
        }

        int longest = 0;
        for(int n : set)
        {
            if(!set.contains(n-1))
            {
                int ll = 1;
                int temp = n;

                while(set.contains(++temp))
                {
                    ll++;
                }
                
                longest = Math.max(longest, ll);

            }
        }

        return longest;

    }
}
