class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String str : tokens) {
            switch (str) {
                case "*":
                    st.push(st.pop() * st.pop());
                    break;
                case "+":
                    st.push(st.pop() + st.pop());
                    break;
                case "/":
                    int rr = st.pop();
                    int ll = st.pop();
                    st.push(ll / rr);
                    break;
                case "-":
                    int r = st.pop();
                    int l = st.pop();
                    st.push(l - r);
                    break;
                default:
                    st.push(Integer.parseInt(str));
            }
        }

        return st.pop();
    }
}
