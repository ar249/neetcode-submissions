class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fre = new HashMap<>();

        for(int i : nums)
        {
            fre.put(i, fre.getOrDefault(i, 0)+1);
        }

        int maxFre = 0;
        for(Map.Entry<Integer, Integer> entry : fre.entrySet())
        {
            maxFre = Math.max(maxFre, entry.getValue());
        }

        List<List<Integer>> buck = new ArrayList<>();
        for(int i=0; i<=maxFre; i++)
        {
            buck.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> entry : fre.entrySet())
        {
            buck.get(entry.getValue()).add(entry.getKey());
        }

        int[] res = new int[k];
        int j = 0;

        for(int i = maxFre; i >= 0; i--)
        {
            List<Integer> ls = buck.get(i);
            for(int n : ls)
            {
                res[j++] = n;
                if(j == k)
                {
                    return res;
                }
            }
        }

        return new int[]{};
    }
}
