class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0;
        int r = heights.length - 1;
        int n = heights.length;

        while(l<r)
        {
            int water = (r-l) * Math.min(heights[l], heights[r]);
            max = Math.max(max, water);
            
            if(heights[l] < heights[r])
            {
                l++;
            }
            else
            {
                r--;
            }
        }

        return max;
    }
}
