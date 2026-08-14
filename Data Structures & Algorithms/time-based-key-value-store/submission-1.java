class TimeMap {

    public record Pair<K, V>(K key, V value) {}

    Map<String, List<Pair<String, Integer>>> mp;

    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key, new ArrayList<>());
        mp.get(key).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> ls = mp.get(key);
        String res = "";

        if(ls == null || ls.size() == 0)
        {
            return res;
        }

        int l = 0;
        int r = ls.size()-1;

        while(l<=r)
        {
            int mid = l + (r-l)/2;
            Pair<String, Integer> p = ls.get(mid);
            
            if(p.value() <= timestamp)
            {
                res = p.key();
                l = mid+1;
            }
            else
            {
                r = mid-1;
            }
        }

        return res;
        
    }
}
