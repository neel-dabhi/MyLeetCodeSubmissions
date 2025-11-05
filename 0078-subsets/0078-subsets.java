class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void subsetsHelper(int[] nums, int idx, List<Integer> path, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList(path));
            return;
        }

        path.add(nums[idx]);
        subsetsHelper(nums, idx + 1, path, result);

        path.remove(path.size() - 1);
        subsetsHelper(nums, idx + 1, path, result);
    }
}