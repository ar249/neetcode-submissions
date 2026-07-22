class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // PriorityQueue<int[]> pq = new PriorityQueue<>(
        //     (a,b) -> a[0]==b[0] ? a[1] - b[1] : a[0] - b[0]
        //     );

        //     Map<Integer, Integer> map = new HashMap<>();
        //     for(int n : nums)
        //     {
        //         map.put(n, map.getOrDefault(n, 0) + 1);
        //     }

        //     for(Map.Entry<Integer, Integer> entry : map.entrySet())
        //     {
        //         pq.add(new int[]{entry.getValue(), entry.getKey()});

        //         if(pq.size() > k)
        //         {
        //             pq.poll();
        //         }
        //     }

        //     List<Integer> res = new ArrayList<>();
        //     for(int i = k; i>0; i--)
        //     {
        //         res.add(pq.poll()[1]);
        //     }

        //     return res.stream().mapToInt(Integer::intValue).toArray();


        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i : nums)
        {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        int max = 0;
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet())
        {
            max = Math.max(max, entry.getValue());
        }


        List<List<Integer>> buckets = new ArrayList<>();
        for(int i =0; i<=max; i++)
        {
            buckets.add(new ArrayList());
        }

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet())
        {
            int b = entry.getValue();
            buckets.get(b).add(entry.getKey());
        }

        List<Integer> res = new ArrayList<>();

        for(int i=max; i>0; i--)
        {
            Collections.sort(buckets.get(i), Collections.reverseOrder());

            for(int z : buckets.get(i))
            {
                res.add(z);

                if(res.size() == k)
                {
                    return res.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
