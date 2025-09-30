class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;

        // Mono Increasing storing Indexes
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < n; i++) {

            while (st.peek() != -1 && heights[st.peek()] > heights[i]) {

                int curr = heights[st.pop()];
                int nextSmaller = i;
                int prevSmaller = st.peek();
                int area = curr * (nextSmaller - prevSmaller - 1);
                max = Math.max(max, area);
            }

            st.push(i);
        }

        while (st.peek() != -1) {
            int curr = heights[st.pop()];
            int nextSmaller = n;
            int prevSmaller = st.peek();
            int area = curr * (nextSmaller - prevSmaller - 1);
            max = Math.max(max, area);
        }

        return max;

    }
}