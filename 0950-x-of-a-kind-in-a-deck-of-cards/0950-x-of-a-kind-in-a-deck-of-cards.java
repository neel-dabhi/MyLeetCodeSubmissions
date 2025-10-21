class Solution {
    public boolean hasGroupsSizeX(int[] deck) {

        HashMap<Integer, Integer> count = new HashMap<>();

        for (int card : deck) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        int res = 0;

        for (int val : count.values()) {
            res = helper(val, res);
        }

        return res > 1;
    }

    private int helper(int a, int b) {

        if (b > 0) {
            return helper(b, a % b);
        } else {
            return a;
        }
    }
}