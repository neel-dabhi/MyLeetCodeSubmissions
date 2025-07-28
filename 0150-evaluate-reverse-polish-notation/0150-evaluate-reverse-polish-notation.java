class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];

            if (!st.isEmpty() && curr.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if (!st.isEmpty() && curr.equals("-")) {
                int first = st.pop();
                int second = st.pop();
                st.push(second - first);
            } else if (!st.isEmpty() && curr.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if (!st.isEmpty() && curr.equals("/")) {
                int first = st.pop();
                int second = st.pop();
                st.push(second / first);
            } else {
                int currInt = Integer.parseInt(curr);
                st.push(currInt);
            }

        }

        return st.peek();

    }
}