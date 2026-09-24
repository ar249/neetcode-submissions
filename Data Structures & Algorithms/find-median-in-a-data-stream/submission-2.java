class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        max.offer(num);

        if(!min.isEmpty() && min.peek() < max.peek())
        {
            min.offer(max.poll());
        }

        if(min.size() > max.size() + 1)
        {
            max.offer(min.poll());
        }
        else if(max.size() > min.size() + 1)
        {
            min.offer(max.poll());
        }
    }
    
    public double findMedian() {
        
        if(min.size() > max.size())
        {
            return min.peek();
        }
        else if(max.size() > min.size())
        {
            return max.peek();
        }

        return (min.peek() + max.peek()) / 2.0;
    }
}
