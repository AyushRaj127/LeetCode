class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int curr = st.pop();
                int prev = st.pop();

                int result = curr + prev;
                st.push(result);
            } else if (tokens[i].equals("*")) {
                int curr = st.pop();
                int prev = st.pop();

                int result = curr * prev;
                st.push(result);
            } else if (tokens[i].equals("/")) {
                int curr = st.pop();
                int prev = st.pop();

                int result = prev / curr;
                st.push(result);
            } else if (tokens[i].equals("-")) {
                int curr = st.pop();
                int prev = st.pop();

                int result = prev - curr;
                st.push(result);
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }

        return st.peek();
    }
}