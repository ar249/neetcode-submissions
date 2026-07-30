class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> fm = new HashMap<>();

        for(char c : t.toCharArray())
        {
            fm.put(c, fm.getOrDefault(c, 0) + 1);
        }
        
        int need = fm.size();
        int have = 0;

        Map<Character, Integer> win = new HashMap<>();
        int l = 0;
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        int minL = 0;

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            win.put(c, win.getOrDefault(c, 0) + 1);

            if(fm.containsKey(c) && fm.get(c).equals(win.get(c)))
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
                win.put(ch, win.get(ch)-1);
                if(fm.containsKey(ch) && fm.get(ch) > win.get(ch))
                {
                    have--;
                }
                l++;
            }
            r++;
        }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minL+minLen); 

    }
}
