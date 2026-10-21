class TimeMap {
    private record Pair(String val, int time){};
    private Map<String, List<Pair>> data;

    public TimeMap() {
        data = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        data.computeIfAbsent(key, k-> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if(data.containsKey(key))
        {
            List<Pair> ls = data.get(key);

            if(ls.size() > 0)
            {
                int l = 0;
                int r = ls.size()-1;

                while(l<=r)
                {
                    int m = l + (r-l)/2;

                    Pair p = ls.get(m);

                    if(p.time() <= timestamp)
                    {
                        res = p.val();
                        l++;
                    }
                    else
                    {
                        r--;
                    }
                }
            }

        }

        return res;
    }
}
