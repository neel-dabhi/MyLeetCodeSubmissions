// TC O(n log n)
// SC O(n)
class Solution {
    public int[][] merge(int[][] intervals) {

        ArrayList<int[]> result = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = result.get(result.size() - 1);

            if (last[1] >= intervals[i][0]) {
                // update the end 
                
                if (last[1] < intervals[i][1]) {
                    last[1] = intervals[i][1];
                }
            } else {
                if (last[1] < intervals[i][1]) {
                    result.add(intervals[i]);
                }
            }
        }
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }

        return res;
    }
}