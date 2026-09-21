class KthLargest {

    PriorityQueue<Integer> pq;
    int num;
    int arr;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();

        for(int i : nums)
        {
            pq.offer(i);
        }

        num = k;
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
