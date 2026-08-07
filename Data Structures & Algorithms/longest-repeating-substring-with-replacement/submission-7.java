class Solution {
    public int characterReplacement(String s, int k) {
         int maxFre = 0;
         int l = 0;
         int cn = 0;
         int[] fre = new int[26];

         int res = 0;

         for(int r = 0; r<s.length(); r++)
         {
            int idx = s.charAt(r) - 'A';
            fre[idx]++;
            maxFre = Math.max(maxFre, fre[idx]);

            cn = r-l+1 - maxFre;

            if(cn > k)
            {
                int i = s.charAt(l) - 'A';
                fre[i]--;
                l++;
            }

            res = Math.max(res, r-l+1);
         }

         return res;
    }
}
