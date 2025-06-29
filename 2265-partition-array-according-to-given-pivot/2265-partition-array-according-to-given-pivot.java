class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] results = new int[nums.length];
        int results_index = 0;

        for(int i=0; i< nums.length; i++)
        {
            if (nums[i] < pivot){
                results[results_index] = nums[i];
                results_index++;
            }
        }

         for(int i=0; i< nums.length; i++)
        {
            if (nums[i] == pivot){
                results[results_index] = nums[i];
                results_index++;
            }
        }
        for(int i=0; i< nums.length; i++){
            if (nums[i] > pivot){
                results[results_index] = nums[i];
                results_index++;
            }
        }

        return results;
    }
}