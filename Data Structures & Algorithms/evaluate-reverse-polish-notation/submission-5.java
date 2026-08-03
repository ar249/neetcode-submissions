class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String str : tokens) {
            try {
                int num = Integer.parseInt(str);
                st.push(num);
            } catch (NumberFormatException e) {
                String opr = str;
                int right = st.pop();
                int left = st.pop();

                if(str.equals("*"))
                {
                    st.push(left * right);
                } 
                else if(str.equals("+"))
                {
                    st.push(left + right);
                }
                else if(str.equals("-"))
                {
                    st.push(left-right);
                }
                else if(str.equals("/"))
                {
                    st.push(left/right);
                }
            }
        }

        return st.pop();
    }
}
