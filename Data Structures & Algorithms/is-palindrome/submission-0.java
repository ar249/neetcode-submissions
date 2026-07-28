class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l<r)
        {
            char la = s.charAt(l);
            char ra = s.charAt(r);

            if(!Character.isLetterOrDigit(la))
            {
                l++;
                continue;
            }

            if(!Character.isLetterOrDigit(ra))
            {
                r--;
                continue;
            }

            if(Character.toLowerCase(la) != Character.toLowerCase(ra))
            {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
