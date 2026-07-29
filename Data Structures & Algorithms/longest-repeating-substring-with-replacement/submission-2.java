class Solution {
    public int characterReplacement(String s, int k) {
         int[] fre = new int[26];
         int maxF = 0;
         int l = 0;
         int r = 0;


         for(int i = 0; i<s.length(); i++)
         {
            int index = s.charAt(i) - 'A';
            fre[index]++;
            maxF = Math.max(maxF, fre[index]);
            
            int ws = r-l+1;
            int cToReplace = ws - maxF;

            if(cToReplace > k)
            {
                int li = s.charAt(l) - 'A';
                fre[li]--;
                l++;
            }
            r++;

         }

         return r-l;
    }
}
