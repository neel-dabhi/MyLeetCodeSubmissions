class Solution {

    Stack<Character> st = new Stack<>();

    public String decodeString(String s) {

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ']') {
                // pop unitll [
                StringBuilder str = new StringBuilder();
                while (st.peek() != '[') {
                    str.insert(0, st.pop());
                }

                st.pop(); // pop [

                // pop unitl isDigit
                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num.insert(0, st.pop());
                }

                for (int j = 0; j < Integer.parseInt(num.toString()); j++) {
                    for (char curr : (str.toString()).toCharArray()) {
                        st.push(curr);
                    }
                }
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }

        return sb.toString();
    }
}