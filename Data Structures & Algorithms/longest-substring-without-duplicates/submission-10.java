class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0;
        int r = 0;
        Set<Character> set = new HashSet<>();

        for(char c : s.toCharArray())
        {
            if(set.contains(c))
            {
                while(set.contains(c))
                {
                    char cl = s.charAt(l);
                    set.remove(cl);
                    l++;
                }
            }

            set.add(c);
            r++;
            max = Math.max(max, r-l);
        }

        return max;
    }
}
