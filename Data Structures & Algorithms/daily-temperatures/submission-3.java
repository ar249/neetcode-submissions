class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int res[] = new int[temp.length];
        Stack<int[]> st = new Stack<>();

        for(int i = temp.length-1; i>=0; i--)
        {
            int t = temp[i];

            while(!st.isEmpty() && st.peek()[0] <= t)
            {
                st.pop();
            }

            if(!st.isEmpty() && st.peek()[0] > t)
            {
                res[i] = st.peek()[1] - i;
            }

            st.push(new int[]{t, i});
        }

        return res;
    }
}
