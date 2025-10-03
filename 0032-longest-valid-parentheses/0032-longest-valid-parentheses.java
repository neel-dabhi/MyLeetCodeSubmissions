class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        
        if(n == 0){
            return 0;
        }

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxLen = 0;

        for (int i = 0; i < n; i++) { // ")()())"
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(i);
            } else {
                st.pop();
                if(!st.isEmpty()){
                    maxLen = Math.max(maxLen, i - st.peek());
                }else{
                    st.push(i);
                }
            }
        }

        return maxLen;
    }
}