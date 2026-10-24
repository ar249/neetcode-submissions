class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();

        for(char c : t.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int l = 0;
        int minL = 0;
        int minLen = Integer.MAX_VALUE;
        int have = 0;
        int need = map.size();

        for(int r = 0; r<s.length(); r++)
        {
            char c = s.charAt(r);
            win.put(c, win.getOrDefault(c, 0) + 1);

            if(map.containsKey(c) && map.get(c).intValue() == win.get(c).intValue())
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

                char cl = s.charAt(l);
                win.put(cl, win.get(cl) - 1);
                l++;

                if(map.containsKey(cl) && map.get(cl) > win.get(cl))
                {
                    have--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minL+minLen);
    }
}
