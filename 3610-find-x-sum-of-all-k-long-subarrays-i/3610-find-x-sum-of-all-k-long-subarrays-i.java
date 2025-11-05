class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {

            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                countMap.put(nums[j], countMap.getOrDefault(nums[j], 0) + 1);
            }
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                list.add(new int[] { entry.getKey(), entry.getValue() });
            }

            // sort the list by value then key
            list.sort((a, b) -> {
                if (a[1] == b[1]) {
                    return Integer.compare(b[0], a[0]);
                }
                return Integer.compare(b[1], a[1]);
            });

            int xSum = 0;
            for (int j = 0; j < x && j < list.size(); j++) {
                xSum += list.get(j)[0] * list.get(j)[1];
            }
            ans[i] = xSum;
        }
        return ans;
    }
}