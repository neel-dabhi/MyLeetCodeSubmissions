class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i])) {
                int val = count.get(nums[i]);
                count.put(nums[i], val + 1);
            } else {
                count.put(nums[i], 1);
            }
        }

        Set<Integer> keys = count.keySet();
        for (Integer key : keys) {
            int val = count.get(key);
            if (val % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}