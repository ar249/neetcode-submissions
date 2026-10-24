class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String s : tokens)
        {
            switch(s)
            {
                case "*": st.push(st.pop() * st.pop()); break;
                case "+": st.push(st.pop() + st.pop()); break;
                case "/": int b = st.pop(); int a = st.pop(); st.push(a/b); break;
                case "-": int b1 = st.pop(); int a1 = st.pop(); st.push(a1-b1); break;
                default: st.push(Integer.parseInt(s)); break;
            }
        }

        return st.pop();
    }
}
