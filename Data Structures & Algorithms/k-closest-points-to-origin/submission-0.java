class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> sqDist(b) - sqDist(a));

        for(int[] p : points)
        {
            pq.offer(p);

            if(pq.size() > k)
            {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];

        for(int i = 0; i<k; i++)
        {
            res[i] = pq.poll();
        }

        return res;
    }

    private int sqDist(int[] a)
    {
        return a[0] * a[0] + a[1] * a[1];
    }
}
