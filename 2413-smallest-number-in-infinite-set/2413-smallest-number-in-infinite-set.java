class SmallestInfiniteSet {
    int smallest;
    PriorityQueue<Integer> pq;
    Set<Integer> set;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        smallest = 1;
    }

    public int popSmallest() {
        if (!pq.isEmpty() && smallest >= pq.peek()) {
            if(smallest == pq.peek()){
                smallest++;
            }
            set.remove(pq.peek());
            return pq.poll();
        }
        int result = smallest;
        smallest++;
        return result;
    }

    public void addBack(int num) {
        if (smallest > num && !set.contains(num)) {
            pq.add(num);
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */