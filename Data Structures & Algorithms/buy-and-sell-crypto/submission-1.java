class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];

        for(int p : prices)
        {
            max = Math.max(max, p-min);
            min = Math.min(min, p);
        }

        return max;
    }
}
