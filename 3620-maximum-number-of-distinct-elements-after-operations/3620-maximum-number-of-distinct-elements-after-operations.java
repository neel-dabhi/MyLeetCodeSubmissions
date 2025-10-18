class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];

        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();

        int last = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            int curr = Math.max(nums[i] - k, last + 1);

            if (curr <= nums[i] + k) {
                nums[i] = curr;
                last = nums[i];
            }
            
        }

        for (int num : nums) {
            set.add(num);
        }
        
        return set.size();
    }
}