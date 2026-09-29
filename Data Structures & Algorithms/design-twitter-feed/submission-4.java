class Twitter {
    private record Pair(Integer time, Integer tweetId) {}
    ;
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Pair>> tweetMap;
    int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
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
        List<Integer> res = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();

        if (followMap.containsKey(userId)) {
            ids.addAll(followMap.get(userId));
        }
        ids.add(userId);

        for (int id : ids) {
            List<Pair> ls = tweetMap.get(id);
            if (ls != null && ls.size() > 0) {
                int idx = ls.size() - 1;
                Pair p = ls.get(idx);
                pq.offer(new int[] {p.time(), p.tweetId(), id, idx});
            }
        }

        while (!pq.isEmpty() && res.size() < 10) {
            int[] tweet = pq.poll();
            int tweetId = tweet[1];
            int id = tweet[2];
            int idx = tweet[3];

            res.add(tweetId);

            if (idx > 0) {
                Pair p = tweetMap.get(id).get(idx - 1);
                pq.offer(new int[] {p.time(), p.tweetId(), id, idx - 1});
            }
        }

        return res;
    }
}
