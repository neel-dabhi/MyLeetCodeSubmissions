class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int pop = 0;
        for (int i = 0; i < pushed.length; i++) {
            st.push(pushed[i]);
            while (!st.isEmpty() && pop < popped.length && st.peek() == popped[pop]) {
                st.pop();
                pop++;
            }
        }

        return st.isEmpty();
    }
}