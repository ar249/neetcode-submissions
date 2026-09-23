class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> b-a);
    }
    
    public void addNum(int num) {
        max.offer(num);

        if(!max.isEmpty() && !min.isEmpty() && max.peek() > min.peek())
        {
            int n = max.poll();
            min.offer(n);
        }

        if(Math.abs(max.size() - min.size()) > 1)
        {
            if(max.size() > min.size())
            {
                int n = max.poll();
                min.offer(n);
            }
            else
            {
                int n = min.poll();
                max.offer(n);
            }
        }
    }
    
    public double findMedian() {
        int size = min.size() + max.size();

        if(size % 2 == 1)
        {
            return min.size() > max.size() ? min.peek() : max.peek();
        }
        else
        {
            return (double)(min.peek() + max.peek()) / 2;
        }
        
    }
}
