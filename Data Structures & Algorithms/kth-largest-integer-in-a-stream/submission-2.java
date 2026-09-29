class KthLargest {

    private PriorityQueue<Integer> pq;
    private int size;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        size = k;

        for(int i : nums)
        {
            pq.offer(i);
        }
    }
    
    public int add(int val) {
        pq.offer(val);

        while(pq.size() > size)
        {
            pq.poll();
        }

        return pq.peek();
    }
}
