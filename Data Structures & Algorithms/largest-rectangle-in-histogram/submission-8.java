class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<=heights.length; i++)
        {
            int ch = (i == heights.length) ? 0 : heights[i];

            while(!st.isEmpty() && ch < heights[st.peek()])
            {
                int top = st.pop();
                int w = st.isEmpty() ? i : i - st.peek() - 1;
                int a = heights[top] * w;
                max = Math.max(max, a);
            }
            st.push(i);
        }

        return max;
    }
}
