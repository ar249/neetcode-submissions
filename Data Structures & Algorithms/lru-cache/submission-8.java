class LRUCache {

    Deque<Integer> order;
    Map<Integer, Integer> data;
    int size;

    public LRUCache(int capacity) {
        order = new ArrayDeque<>();
        data = new HashMap<>();
        size = capacity;
    }
    
    public int get(int key) {
        if(data.containsKey(key))
        {
            int val = data.get(key);

            order.remove(key);
            order.addFirst(key);

            return val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        data.put(key, value);

        if(data.size() > size)
        {
            int k = order.removeLast();
            data.remove(k);
        }

        order.remove(key);
        order.addFirst(key);
    }
}
