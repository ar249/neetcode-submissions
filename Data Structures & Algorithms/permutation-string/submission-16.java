class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int l = 0;
        int r = s1.length()-1;
        String s1k = getKey(s1);

        while(r<s2.length())
        {
            String str = s2.substring(l, r+1);
            if(getKey(str).equals(s1k))
            {
                return true;
            }

            l++;
            r++;
        }

        return false;
        
    }

    private String getKey(String s)
    {
        int[] arr = new int[26];

        for(int i =0; i<s.length(); i++)
        {
            arr[s.charAt(i) - 'a']++;
        }

        return Arrays.toString(arr);
    }
}
