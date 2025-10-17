class MedianFinder {
    PriorityQueue<Double> small;
    PriorityQueue<Double> large;

    public MedianFinder() {
        //small is MAX heap, we want laregest of smaller elements
        small = new PriorityQueue<Double>(Comparator.reverseOrder());
        //large is MIN heap, we want smallest of larger elements
        large = new PriorityQueue<Double>();
    }

    public void addNum(int num) {
        small.add((double) num); // ADD MAX HEAP

        if (large.size() > 0 && small.peek() > large.peek()) {
            large.add(small.poll());
        }

        if (small.size() - 1 > large.size()) {
            large.add(small.poll());
        }

        if (large.size() > small.size()) {
            small.add(large.poll());
        }
        
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }
        return (small.peek() + large.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */