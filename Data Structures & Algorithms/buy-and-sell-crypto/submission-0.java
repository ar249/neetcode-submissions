class Solution {
    public int maxProfit(int[] prices) {
        int resProf = 0;
        int min = prices[0];

        for(int i = 1; i<prices.length; i++)
        {
            int p = prices[i];
            resProf = Math.max(resProf, p-min);
            min = Math.min(min, p);
        }

        return resProf;
        
    }
}
