class Solution {
    public int largestRectangleArea(int[] heights) {
       int max = 0;
       Stack<Integer> st = new Stack<>();
       int n = heights.length;

       for(int i =0; i<=n; i++)
       {
        int ch = (i==n) ? 0 : heights[i];

        while(!st.isEmpty() && ch < heights[st.peek()])
        {
            int top = st.pop();
            int width = st.isEmpty() ? i : i - st.peek() - 1;
            int area = width * heights[top];

            max = Math.max(max, area);
        }

        st.push(i);
       }

       return max;
    }
}
