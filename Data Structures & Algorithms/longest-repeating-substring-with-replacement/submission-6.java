class Solution {
    public int characterReplacement(String s, int k) {
         int l = 0;
         int maxLen = Integer.MIN_VALUE;

         int maxFre = Integer.MIN_VALUE;
         int[] fre = new int[26];
         int changeNeeded = 0;

         for(int r = 0; r<s.length(); r++)
         {
            char c = s.charAt(r);
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
            maxLen = Math.max(maxLen, r-l+1);
         }

         return maxLen;
    }
}
