class KthLargest {
    PriorityQueue<Integer> pq;
    int num;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        num = k;

        for(int i : nums)
        {
            pq.offer(i);
        }
    }
    
    public int add(int val) {
        pq.offer(val);

        while(pq.size() > num)
        {
            pq.poll();
        }

        return pq.peek();
    }
}
