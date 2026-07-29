class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;

        int max = 0;

        for (int i = 0; i < s.length(); i++) 
        {
            char c = s.charAt(i);
            if (set.contains(c)) 
            {
                while (set.contains(c)) {
                    char lc = s.charAt(l);
                    set.remove(lc);
                    l++;
                }

                set.add(c);
                r++;
                max = Math.max(max, r-l);
            } 
            else 
            {
                set.add(c);
                r++;
                max = Math.max(max, r-l);
            }
        }

        return max;
    }
}
