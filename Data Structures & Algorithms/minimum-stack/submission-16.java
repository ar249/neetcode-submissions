class MinStack {
    Stack<int[]> st;

    public MinStack() {
      st = new Stack<>();
    }
    
    public void push(int val) {
        int min = val;
        if(!st.isEmpty())
        {
          min = (st.peek()[1] <= val) ? st.peek()[1] : val;
        }

        st.push(new int[]{val, min});
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek()[0];
    }
    
    public int getMin() {
        return st.peek()[1];
    }
}
