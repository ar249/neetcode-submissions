class Twitter {
    private record Pair(Integer time, Integer tweetId) {}
    ;
    private Map<Integer, List<Pair>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;
    private int time;
    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
        time = 0;
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
        if (followMap.containsKey(followerId)) {
            if (followMap.get(followerId).contains(followeeId)) {
                followMap.get(followerId).remove(followeeId);
            }
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<Integer> set = new HashSet<>();

        if (followMap.containsKey(userId)) {
            set.addAll(followMap.get(userId));
        }

        set.add(userId);

        for (int i : set) {
            if (tweetMap.containsKey(i)) {
                List<Pair> ls = tweetMap.get(i);

                if (ls.size() > 0) {
                    int idx = ls.size() - 1;
                    Pair p = ls.get(idx);
                    pq.offer(new int[]{p.time(), p.tweetId(), i, idx});
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        while(!pq.isEmpty() && res.size() < 10)
        {
            int[] news = pq.poll();
            int tweetId = news[1];
            int followeeId = news[2];
            int idx = news[3];

            res.add(tweetId);

            if(idx > 0)
            {
                Pair p = tweetMap.get(followeeId).get(idx-1);
                pq.offer(new int[]{p.time(), p.tweetId(), followeeId, idx-1});
            }
        }

        return res;
    }
}
