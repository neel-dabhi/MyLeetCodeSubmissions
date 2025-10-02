class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();

        int index = -1;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i - 1] > digits[i]) {
                digits[i - 1]--;
                index = i;
            }
        }

        if (index == -1) {
            return n;
        }

        for (int i = index; i < digits.length; i++) {
            digits[i] = '9';
        }

        return Integer.parseInt(new String(digits));

    }

}