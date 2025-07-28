// TC: O(n)
// SC: O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            if (curr.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if (curr.equals("-")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a - b);
            } else if (curr.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if (curr.equals("/")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a / b);
            } else {
                st.push(Integer.parseInt(curr));
            }
        }
        return st.peek();
    }
}