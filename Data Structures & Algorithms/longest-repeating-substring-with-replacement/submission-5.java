class Solution {
    public int characterReplacement(String s, int k) {
         int l = 0;
         int r = 0;

         int maxFre = Integer.MIN_VALUE;
         int[] fre = new int[26];
         int changeNeeded = 0;

         for(int i = 0; i<s.length(); i++)
         {
            char c = s.charAt(i);
            int index = c - 'A';
            fre[index]++;
            maxFre = Math.max(maxFre, fre[index]);

            changeNeeded = r-l+1 - maxFre;

            if(changeNeeded > k)
            {
                int idx = s.charAt(l) - 'A';
                fre[idx]--;
                l++;
            }
            r++;
         }

         return r-l;
    }
}
