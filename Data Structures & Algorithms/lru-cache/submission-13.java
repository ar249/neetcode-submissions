class LRUCache {
    Deque<Integer> order;
    Map<Integer, Integer> data;
    int cap;


    public LRUCache(int capacity) {
        order = new ArrayDeque<>();
        data = new HashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        if(data.containsKey(key))
        {
            order.remove(key);
            order.addFirst(key);
            return data.get(key);
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(data.containsKey(key))
        {
            data.put(key, value);
            order.remove(key);
            order.addFirst(key);
        }
        else
        {
            if(data.size() == cap)
            {
                int k = order.removeLast();
                data.remove(k);
            }
            
            order.addFirst(key);
            data.put(key, value);
        }
    }
}
