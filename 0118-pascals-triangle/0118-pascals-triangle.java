class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();

            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    row.add(1);
                } else if (j == i) {
                    row.add(1);
                } else if (j > 0) {
                    row.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                }
            }

            result.add(row);

        }

        return result;
    }
}