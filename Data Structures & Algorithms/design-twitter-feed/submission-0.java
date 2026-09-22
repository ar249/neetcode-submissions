class Twitter {
    public record Pair(Integer time, Integer twid) {}
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Pair>> tweetMap;
    private int time = 0;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        time++;
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Pair(time, tweetId));
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> fm = followMap.get(followerId);

        if (fm.contains(followeeId)) {
            fm.remove(followeeId);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Set<Integer> set = new HashSet<>();

        if (followMap.containsKey(userId)) {
            set.addAll(followMap.get(userId));
        }
                    set.add(userId);


        List<Integer> res = new ArrayList<>();

        for(int i : set)
        {
            List<Pair> ls = tweetMap.get(i);

            if(ls != null && ls.size() > 0)
            {
                int idx = ls.size()-1;
                Pair p = ls.get(idx);
                pq.offer(new int[]{p.time(), p.twid(), i, idx});
            }
        }

        while(!pq.isEmpty() && res.size()<10)
        {
            int[] cur = pq.poll();
            int twid = cur[1];
            int fwid = cur[2];
            int id = cur[3];

            res.add(twid);

            if(id > 0)
            {
                Pair p = tweetMap.get(fwid).get(id-1);
                pq.offer(new int[]{p.time(), p.twid(), fwid, id-1});
            }
        }

        return res;
    }
}
