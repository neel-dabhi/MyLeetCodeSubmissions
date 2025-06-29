class Solution {
    int result = 0;

    public int subsetXORSum(int[] nums) {
        backtrack(nums, 0, new ArrayList<Integer>());
        return result;
    }

    private void backtrack(int[] nums, int index, ArrayList<Integer> curr) {

        // base 
        if (index == nums.length) {
            int init =0;
            for (Integer val : curr) {
                init = init ^ val;
            }
            result = result + init;
            return;
        }

        //choose
        curr.add(nums[index]);
        backtrack(nums, index + 1, curr);
        curr.remove(curr.size() - 1);

        // not choose
        backtrack(nums, index + 1, curr);
    }
}