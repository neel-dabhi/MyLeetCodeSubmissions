class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int h = height.length - 1;
        int area = 0;
        while (l < h) {
            int minHight = Math.min(height[l], height[h]);

            area = Math.max(area, minHight * (h - l));

            if (height[l] <= height[h]) {
                l++;
            } else {
                h--;
            }
        }
        return area;
    }
}