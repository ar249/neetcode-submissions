class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        int l = 0;
        int r = s.length() - 1;

        while(l<=r)
        {
            if(Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r)))
            {
                l++;
                r--;
            }
            else
            {
                return false;
            }
        }

        return true;
    }
}
