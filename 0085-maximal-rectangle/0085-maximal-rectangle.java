class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int result = 0;

        int[][] prefixArr = new int[r][c];

        for (int col = 0; col < c; col++) {
            int sum = 0;
            for (int row = 0; row < r; row++) {
                sum = sum + (matrix[row][col] - '0');

                if ((matrix[row][col]) == '0') {
                    sum = 0;
                }

                prefixArr[row][col] = sum;
            }
        }

        for (int i = 0; i < r; i++) {
            result = Math.max(result, largestAreaInrow(prefixArr[i]));
        }

        return result;
    }

    private int largestAreaInrow(int[] row) {

        int max = 0;

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < row.length; i++) {

            while (st.peek() != -1 && row[st.peek()] > row[i]) {

                int curr = st.pop();
                int nextSmaller = i;
                int prevSmaller = st.peek();

                int area = row[curr] * (nextSmaller - prevSmaller - 1);
                max = Math.max(max, area);
            }

            st.push(i);
        }

        while (st.peek() != -1) {
            int curr = st.pop();
            int nextSmaller = row.length;
            int prevSmaller = st.peek();

            int area = row[curr] * (nextSmaller - prevSmaller - 1);
            max = Math.max(max, area);
        }

        return max;
    }

}