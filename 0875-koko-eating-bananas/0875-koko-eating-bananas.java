class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int val : piles) {
            high = Math.max(high, val);
        }

        int ans = 0;
        while (low <= high) {
            int maybeK = low + (high - low) / 2;

            if (canEatAllBanana(piles, maybeK, h)) {
                // save & find lower
                ans = maybeK;
                high = maybeK - 1;
            } else {
                // increase k
                low = maybeK + 1;
            }
        }
        return ans;
    }

    private boolean canEatAllBanana(int[] piles, int k, int h) {
        int hoursePassed = 0;
        for (int i = 0; i < piles.length; i++) {
            hoursePassed += Math.ceil((double) piles[i] / k);
        }

        return hoursePassed <= h;
    }
}