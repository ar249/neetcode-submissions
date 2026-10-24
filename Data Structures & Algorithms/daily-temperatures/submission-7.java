class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> st = new Stack<>();
        int[] res = new int[temp.length];

        for(int i = temp.length-1; i>= 0; i--)
        {
            int t = temp[i];

            while(!st.isEmpty() && t >= st.peek()[0])
            {
                st.pop();
            }

            if(!st.isEmpty() && t < st.peek()[0])
            {
                res[i] = st.peek()[1] - i;
            }

            st.push(new int[]{t, i});
        }

        return res;
    }
}
