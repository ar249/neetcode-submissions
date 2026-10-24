class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];

        for(char c : tasks)
        {
            arr[c - 'A']++;
        }

        int maxFre = Integer.MIN_VALUE;
        for(int i : arr)
        {
            maxFre = Math.max(maxFre, i);
        }

        int maxFreCount = 0;
        for(int i : arr)
        {
            if(i == maxFre)
            {
                maxFreCount++;
            }
        }

        int tt = (maxFre-1) * (n+1) + maxFreCount;

        return Math.max(tasks.length, tt);
    }
}
