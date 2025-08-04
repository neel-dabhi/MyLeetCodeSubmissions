// TC: (m *n)
// SC: O(1)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = triangle.size() - 2; i >=0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int curr = triangle.get(i).get(j);
                int case1 = curr + triangle.get(i + 1).get(j);
                int case2 = curr + triangle.get(i + 1).get(j + 1);
                triangle.get(i).set(j, Math.min(case1, case2));
            }
        }

        return triangle.get(0).get(0);
    }
}