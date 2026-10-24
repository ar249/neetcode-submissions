class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray())
        {
            if(c == ')' || c == '}' || c == ']')
            {
                if(!st.isEmpty())
                {
                    if(c == '}' && st.peek() != '{' 
                    || c == ')' && st.peek() != '('
                    || c == ']' && st.peek() != '[')
                    {
                        return false;
                    }
                    else
                    {
                        st.pop();
                        continue;
                    }

                }
                else
                {
                    return false;
                }
            }
            else
            {
                st.push(c);
            }
        }

        return st.isEmpty() ? true : false;
    }
}
