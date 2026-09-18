class Solution {
    public int characterReplacement(String s, int k) {
         int l = 0;
         int res = 0;
         int maxF = 0;
         int[] fre = new int[26];

         for(int r =0; r < s.length(); r++)
         {
            int idx = s.charAt(r) - 'A';
            fre[idx]++;

            maxF = Math.max(maxF, fre[idx]);

            int cn = r-l+1 - maxF;

            if(cn > k)
            {
                int id = s.charAt(l) - 'A';
                fre[id]--;
                l++;
            }

            res = Math.max(res, r-l+1);
         }

         return res;
    }
}
