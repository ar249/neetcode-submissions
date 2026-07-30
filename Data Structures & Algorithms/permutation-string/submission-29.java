class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] array = s1.toCharArray();
        Arrays.sort(array);


        int l = 0;
        int r = s1.length()-1;

        while(r<s2.length())
        {
            String s = s2.substring(l, r+1);
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            if(Arrays.equals(arr, array))
            {
                return true;
            }
            l++; r++;
        }
        return false;
    }
}
