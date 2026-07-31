class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[')
            {
                stack.push(c);
            }
            else
            {
                if(!stack.isEmpty())
                {
                    char ch = stack.peek();
                    if(ch == '(' && c == ')' 
                    || ch == '{' && c == '}' 
                    || ch == '[' && c == ']')
                    {
                        stack.pop();
                    }
                    else{
                        return false;
                    }

                }
                else
                {
                    return false;
                }
            }
               
        }


        return stack.isEmpty() ? true : false;
    }
}
