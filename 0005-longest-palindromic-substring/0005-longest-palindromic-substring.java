// TC: O(n*n)
// SC: O(1)
class Solution {
    int start = 0;
    int end = 0;
    public String longestPalindrome(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            expand(s, i, i);

            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                expand(s, i, i + 1);
            }
        }

        return s.substring(start, end + 1);
    }

    private void expand(String s, int right, int left) {

        while (right < s.length() && left >= 0 && s.charAt(right) == s.charAt(left)) {
            left--;
            right++;
        }

        // one step back 
        left++;
        right--;

        if (end - start < right - left) {
            end = right;
            start = left;
        }
    }

}