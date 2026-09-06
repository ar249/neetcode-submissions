class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int res = 0;

        for(int i =0; i<= heights.length; i++)
        {
            int currH = i == heights.length ? 0 : heights[i];

            while(!st.isEmpty() && currH < heights[st.peek()])
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
