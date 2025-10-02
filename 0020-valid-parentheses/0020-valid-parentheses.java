class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(')');
            } else if (ch == '[') {
                st.push(']');
            } else if (ch == '{') {
                st.push('}');
            } else if (st.isEmpty() || ch != st.pop()) {
                return false;
            }
        }
        return st.isEmpty();
    }
}