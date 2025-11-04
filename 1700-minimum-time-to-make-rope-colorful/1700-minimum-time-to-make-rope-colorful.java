class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i = 0;
        int cost = 0;
        int n = colors.length();
        while (i < n) {
            int j = i;
            int max = 0;
            int sum = 0;
            while (j < n && colors.charAt(i) == colors.charAt(j)) {
                sum = sum + neededTime[j];
                max = Math.max(neededTime[j], max);
                j++;
            }
            cost += sum - max;
            i=j;
        }
        return cost;
    }
}