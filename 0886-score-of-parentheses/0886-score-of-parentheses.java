class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int val = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                st.push(val);
                val = 0;
            } else {
                val = st.pop() + Math.max(2 * val, 1);
            }

        }
        return val;
    }
}