class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int res = 0;

        for(int i = 0; i<= heights.length; i++)
        {
            int ch = (i == heights.length) ? 0 : heights[i];

            while(!st.isEmpty() && ch < heights[st.peek()])
            {
                int topIdx = st.pop();
                int width = st.isEmpty() ? i : i-st.peek()-1;
                int area = heights[topIdx] * width;
                res = Math.max(res, area);
            }

            st.push(i);
        }

        return res;
    }
}
