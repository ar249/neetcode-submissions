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
                    char ch = s.charAt(l);
                    set.remove(ch);
                    l++;
                }

                set.add(c);
                r++;
                max = Math.max(max, r-l);
            }
            else
            {
                r++;
                set.add(c);
                max = Math.max(max, r-l);
            }
        }

        return max;
    }
}
