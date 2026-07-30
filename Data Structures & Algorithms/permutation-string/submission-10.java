class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 > len2) return false;
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        
        // Populate frequency for the first window
        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        
        // Track how many character frequencies match exactly
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) matches++;
        }
        
        // Slide the window across s2
        for (int i = 0; i < len2 - len1; i++) {
            if (matches == 26) return true;
            
            int rightChar = s2.charAt(i + len1) - 'a';
            int leftChar = s2.charAt(i) - 'a';
            
            // Add right character to window
            count2[rightChar]++;
            if (count1[rightChar] == count2[rightChar]) {
                matches++;
            } else if (count1[rightChar] + 1 == count2[rightChar]) {
                matches--;
            }
            
            // Remove left character from window
            count2[leftChar]--;
            if (count1[leftChar] == count2[leftChar]) {
                matches++;
            } else if (count1[leftChar] - 1 == count2[leftChar]) {
                matches--;
            }
        }
        
        return matches == 26;
    }
}
