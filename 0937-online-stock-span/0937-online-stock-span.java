class StockSpanner {

    Stack<int[]> st; // price, span

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!st.isEmpty() && price >= st.peek()[0]) {
            span = span + st.pop()[1];
        }
        st.push(new int[] { price, span });

        return st.peek()[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */