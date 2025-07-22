// TC: O(n)
// SC: O(n)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<Integer>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int poppedIdx = st.pop();
                result[poppedIdx] = i - poppedIdx;
            }
            st.push(i);
        }

        return result;
    }
}