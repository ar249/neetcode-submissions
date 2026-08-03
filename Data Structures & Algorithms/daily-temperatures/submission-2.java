class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> st = new Stack<>();
        int[] res = new int[temp.length];


        for(int i = temp.length-1; i>=0; i--)
        {
            if(!st.isEmpty())
            {
                while(!st.isEmpty() && st.peek()[0] <= temp[i])
                {
                    st.pop();
                }

                if(!st.isEmpty() && st.peek()[0] > temp[i])
                {
                    res[i] = st.peek()[1] - i;
                }
            }

            st.push(new int[]{temp[i], i});
        }

        return res;
    }
}
