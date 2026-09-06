class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int res = 0;

        for(int i = 0; i<= heights.length; i++)
        {
            int ch = i == heights.length ? 0 : heights[i];

            while(!st.isEmpty() && heights[st.peek()] > ch)
            {
                int top = st.pop();
                int w = st.isEmpty() ? i : i-st.peek()-1;
                int a = w * heights[top];

                res = Math.max(res, a);
            }

            st.push(i);
        }

        return res;
    }
}
