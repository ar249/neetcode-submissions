class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for(String str : strs)
        {
            int[] count = new int[26];
            for(char c : str.toCharArray())
            {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            m.putIfAbsent(key, new ArrayList<>());
            m.get(key).add(str);
        }

        List<List<String>> result = new ArrayList<>(m.values());

        return result;
    }
}
