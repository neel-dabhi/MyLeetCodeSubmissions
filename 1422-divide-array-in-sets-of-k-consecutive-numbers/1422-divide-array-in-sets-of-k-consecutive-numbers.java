class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;

        if (n % k != 0) {
            return false;
        }
        Arrays.sort(nums);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        while (!map.isEmpty()) {

            for (int i = 0; i < k; i++) {
                int val = min + i;
                if (map.containsKey(val)) {
                    map.put(val, map.get(val) - 1);
                    if (map.get(val) == 0) {
                        map.remove(val);
                    }
                } else {
                    return false;
                }

                if (i == k - 1 && !map.isEmpty()) {
                    min = map.firstKey();
                }
            }

        }

        return true;
    }
}