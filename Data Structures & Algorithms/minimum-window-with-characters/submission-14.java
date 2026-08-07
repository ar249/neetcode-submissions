class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();

        for(char c : t.toCharArray())
        {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        int need = mp.size();
        int have = 0;

        int minLen = Integer.MAX_VALUE;
        int minL = 0;
        int l = 0;

        for(int r = 0; r<s.length(); r++)
        {
            char c = s.charAt(r);
            win.put(c, win.getOrDefault(c, 0) + 1);

            if(mp.containsKey(c) && win.get(c).equals(mp.get(c)))
            {
                have++;
            }

            while(have == need)
            {
                if(r-l+1 < minLen)
                {
                    minLen = r-l+1;
                    minL = l;
                }

                char ch = s.charAt(l);
                win.put(ch, win.get(ch) - 1);
                l++;

                if(mp.containsKey(ch) && mp.get(ch) > win.get(ch))
                {
                    have--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minL + minLen);
    }
}
