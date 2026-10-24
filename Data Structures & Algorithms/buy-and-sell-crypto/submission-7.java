class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int p : prices)
        {
            min = Math.min(p, min);
            max = Math.max(max, p-min);
        }

        return max;
    }
}
