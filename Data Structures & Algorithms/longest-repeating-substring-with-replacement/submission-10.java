class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int[] fre = new int[26];
        int maxFre = 0;
        int res = 0;

        for(int r = 0; r<s.length(); r++)
        {
            int id = s.charAt(r) - 'A';
            fre[id]++;
            maxFre = Math.max(maxFre, fre[id]);

            int cn = r-l+1 - maxFre;

            if(cn > k)
            {
                int lx = s.charAt(l) - 'A';
                fre[lx]--;
                l++;
            }

            res = Math.max(res, r-l+1);
        }

        return res;
    }
}
