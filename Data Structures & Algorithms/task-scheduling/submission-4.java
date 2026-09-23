class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] fre = new int[26];
        for(char c : tasks)
        {
            fre[c - 'A']++;
        }

        int maxFre = 0;
        for(int i : fre)
        {
            maxFre = Math.max(maxFre, i);
        }

        int maxFreCount = 0;
        for(int i : fre)
        {
            if(maxFre == i)
            {
                maxFreCount++;
            } 
        }

        int minCount = (n+1) * (maxFre-1) + maxFreCount;

        return Math.max(tasks.length, minCount);
    }
}
