class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        // Frequency array for characters in t
        int[] targetFreq = new int[128];
        for (char c : t.toCharArray()) {
            targetFreq[c]++;
        }
        
        // Count of unique characters in t that need to be matched
        int required = 0;
        for (int count : targetFreq) {
            if (count > 0) required++;
        }
        
        int l = 0, r = 0;
        int formed = 0;
        int[] windowFreq = new int[128];
        
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        while (r < s.length()) {
            char c = s.charAt(r);
            windowFreq[c]++;
            
            if (targetFreq[c] > 0 && windowFreq[c] == targetFreq[c]) {
                formed++;
            }
            
            // Try and contract the window until it ceases to be desirable
            while (l <= r && formed == required) {
                char leftChar = s.charAt(l);
                
                // Update minimum window found so far
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minStart = l;
                }
                
                windowFreq[leftChar]--;
                if (targetFreq[leftChar] > 0 && windowFreq[leftChar] < targetFreq[leftChar]) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}