class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        if(n1>n2) return false;

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for(int i =0; i<n1; i++)
        {
            a1[s1.charAt(i) - 'a']++;
            a2[s2.charAt(i) - 'a']++;
        }

        for(int i =0; i<= n2-n1; i++)
        {
            if(Arrays.equals(a1, a2))
            {
                return true;
            }

            if(n1+i < n2)
            {
                a2[s2.charAt(i) - 'a']--;
                a2[s2.charAt(n1+i) - 'a']++;
            }
        }

        return false;
    }
}
