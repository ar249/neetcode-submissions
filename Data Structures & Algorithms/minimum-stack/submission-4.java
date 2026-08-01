class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;

    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(val);
            min.push(val);
        } else {
            st.push(val);
            if (val >= min.peek()) {
                min.push(min.peek());
            } else {
                min.push(val);
            }
        }
    }

    public void pop() {
        st.pop();
        min.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
