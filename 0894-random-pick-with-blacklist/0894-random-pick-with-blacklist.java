class Solution {
    int num = 0;
    HashSet<Integer> set;
    HashMap<Integer, Integer> map;
    int M = 0;

    public Solution(int n, int[] blacklist) {
        num = n;
        map = new HashMap<>();
        set = new HashSet<>();
        M = n - blacklist.length;
        for (int b : blacklist) {
            set.add(b);
        }
        int last = n - 1;
        for (int b : blacklist) {
            if (b < M) {
                while (set.contains(last)) {
                    last--;
                }
                map.put(b, last);
                last--;
            }

        }
    }

    public int pick() {
        int rand = new Random().nextInt(M);
        if (set.contains(rand)) {
            return map.get(rand);
        }

        return rand;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */