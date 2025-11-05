class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private void combinationSumHelper(int[] candidates, int idx, int target, List<Integer> path, List<List<Integer>> result) {
        // base cases
        if( target < 0 || idx == candidates.length){
            return;
        }

        if( target == 0){
            result.add( new ArrayList<>(path));
            return;
        }

        // logic
        int curr = candidates[idx];
        // choose curr
        path.add(curr);
        combinationSumHelper(candidates, idx, target - curr, path, result);

        // not choose curr
        path.remove(path.size() -1);
        combinationSumHelper(candidates, idx + 1, target, path, result);

    }
}