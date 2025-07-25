// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> peekingIterator;
    private Integer nextEl = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.peekingIterator = iterator;
        if (peekingIterator.hasNext()) {
            this.nextEl = peekingIterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextEl;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result = nextEl;
        if (peekingIterator.hasNext()) {
            nextEl = peekingIterator.next();
        } else {
            nextEl = null;
        }

        return result;
    }

    @Override
    public boolean hasNext() {
        return nextEl != null;
    }
}