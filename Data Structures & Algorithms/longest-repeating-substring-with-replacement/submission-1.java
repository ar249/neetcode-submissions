class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int[] freq = new int[26];
        int l = 0;
        int r = 0;

        int maxFreq = 0;

        for(int i = 0; i<s.length(); i++)
        {
            int ind = s.charAt(i) - 'A';
            freq[ind]++;
            maxFreq = Math.max(maxFreq, freq[ind]);

            int window = r-l+1;
            int charsToReplace = window-maxFreq;

            if(charsToReplace > k)
            {
                int index = s.charAt(l) - 'A';
                freq[index]--;
                l++;
            }
            r++;
        }

        return r-l;
    }
}
