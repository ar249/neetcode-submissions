class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0]==b[0] ? a[1] - b[1] : a[0] - b[0]
            );

            Map<Integer, Integer> map = new HashMap<>();

            for(int n : nums)
            {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }


            for(Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                pq.add(new int[]{entry.getValue(), entry.getKey()});

                if(pq.size() > k)
                {
                    pq.poll();
                }
            }

            List<Integer> res = new ArrayList<>();

            for(int i = k; i>0; i--)
            {
                res.add(pq.poll()[1]);
            }

            return res.stream().mapToInt(Integer::intValue).toArray();



    }
}
