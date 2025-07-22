// TC: O(n)
// SC: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<Integer>();
        int[] result = new int[nums.length];
        int n = nums.length;
        Arrays.fill(result, -1);

        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int idx = st.pop();
                result[idx] = nums[i % n];
            }
            if (i < n) {
                st.push(i);
            }
        }
        return result;
    }
}