class Solution {
    public int findSmallestInteger(int[] nums, int value) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int key = ((nums[i] % value) + value) % value;
                map.put(key, map.getOrDefault(key, 0) + 1);

            } else {
                int key = nums[i] % value;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        int i = 0;
        while (true) {
            int key = i % value;
            if (map.getOrDefault(key, 0) == 0) {
                return i;
            }
            map.put(key, map.get(key) - 1);
            i++;
        }
    }
}
