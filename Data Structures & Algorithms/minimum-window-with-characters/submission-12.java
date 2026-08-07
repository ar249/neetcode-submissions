class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();
        Map<Character, Integer> win = new HashMap<>();

        for(char c : t.toCharArray())
        {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = mp.size();
        int minLen = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int minL = 0;

        for(int i =0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            win.put(c, win.getOrDefault(c, 0) + 1);

            if(mp.containsKey(c) && mp.get(c).equals(win.get(c)))
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
                l++;

                if(mp.containsKey(ch) &&  win.get(ch) < mp.get(ch))
                {
                    have--;
                }
            }
            r++;
        } 

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minL+minLen);
    
    }
}
