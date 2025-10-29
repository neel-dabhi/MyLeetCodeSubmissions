class CountIntervals {

    TreeMap<Integer, Integer> treeMap;
    int count;

    public CountIntervals() {
        treeMap = new TreeMap<>();
        count = 0;
    }

    public void add(int left, int right) {
        Map.Entry<Integer, Integer> entry = treeMap.floorEntry(right);

        while (entry != null && entry.getValue() >= left) {
            int l = entry.getKey();
            int r = entry.getValue();

            count -= r - l + 1;
            treeMap.remove(l);

            left = Math.min(left, l);
            right = Math.max(right, r);

            entry = treeMap.floorEntry(right);
        }

        treeMap.put(left, right);
        count += right - left + 1;
    }

    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */