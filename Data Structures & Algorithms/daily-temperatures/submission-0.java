class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int[] res = new int[temperatures.length];
        
        for(int i=temperatures.length-1; i>=0; i--)
        {
            if(!st.isEmpty())
            {
                while(!st.isEmpty() && st.peek()[0] <= temperatures[i])
                {
                    st.pop();
                }

                if(!st.isEmpty() && st.peek()[0] > temperatures[i])
                {
                    res[i] = st.peek()[1]-i;
                }
            }
                st.push(new int[] {temperatures[i], i});
        }

        return res;
    }
}
