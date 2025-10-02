class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];
            boolean alive = true;

            while (alive && curr < 0 && !st.isEmpty() && st.peek() > 0) {
                if (Math.abs(curr) > Math.abs(st.peek())) {
                    st.pop();
                } else if (Math.abs(curr) == Math.abs(st.peek())) {
                    alive = false;
                    st.pop();
                }else{
                    alive = false;
                }
            }

            if (alive) {
                st.push(curr);
            }
        }

        int[] result = new int[st.size()];
        int i = result.length - 1;

        while (!st.isEmpty()) {
            result[i] = st.pop();
            i--;
        }

        return result;
    }
}