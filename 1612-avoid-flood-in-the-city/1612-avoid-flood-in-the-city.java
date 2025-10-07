class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        HashMap<Integer, Integer> map = new HashMap<>(); // Stores Lake -> Day Rained 
        TreeSet<Integer> set = new TreeSet<Integer>(); // stores indexes of 0

        for (int i = 0; i < n; i++) {

            if (rains[i] > 0) {
                ans[i] = -1;
                if (map.containsKey(rains[i])) {
                    Integer x = set.higher(map.get(rains[i]));
                    if (x == null) {
                        return new int[0];
                    }
                    ans[x] = rains[i];
                    set.remove(x);
                }

                map.put(rains[i], i);
            } else if (rains[i] == 0) {
                set.add(i);
            }
        }
        return ans;
    }
}