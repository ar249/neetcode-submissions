class Solution {
    public int characterReplacement(String s, int k) {
         int l = 0;
         int r = 0;
         int maxFreq = 0;
         int[] fre = new int[26];

         for(int i = 0; i < s.length(); i++)
         {
            int index = s.charAt(i) - 'A';
            fre[index]++;
            maxFreq = Math.max(maxFreq, fre[index]);

            int ws = r-l+1;
            int cn = ws - maxFreq;

            if(cn>k)
            {
                int ind = s.charAt(l) - 'A';
                fre[ind]--;
                l++;
            }
            r++;
         }

         return r-l;
    }
}
