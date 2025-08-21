class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty())
            return 0;

        boolean sign = true;
        char firstChar = s.charAt(0);
        if (!Character.isDigit(firstChar) && firstChar != '-' && firstChar != '+') {
            return 0;
        }
        if (!Character.isDigit(firstChar)) {
            if (firstChar == '-') {
                sign = false;
            }
        }

        int limit = Integer.MAX_VALUE / 10;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                if (result > limit) {
                    if (sign) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (result == limit) {
                    if (ch - '0' >= 8) {
                        if (sign) {
                            return Integer.MAX_VALUE;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    }
                }
                result = result * 10 + ch - '0';

            } else {
                if (i != 0) {
                    break;
                }
            }
        }
        if (sign) {
            return result;
        }
        return -result;
    }
}