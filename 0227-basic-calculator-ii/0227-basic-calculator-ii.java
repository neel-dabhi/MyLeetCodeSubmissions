class Solution {
    public int calculate(String s) {
        int solution = 0;
        char lastSign = '+';
        int tail = 0;
        int curr = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                curr = curr * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (lastSign == '+') {
                    solution = solution + curr;
                    tail = +curr;
                } else if (lastSign == '-') {
                    solution = solution - curr;
                    tail = -curr;
                } else if (lastSign == '*') {
                    solution = solution - tail + (tail * curr);
                    tail = tail * curr;
                } else if (lastSign == '/') {
                    solution = solution - tail + tail / curr;
                    tail = tail / curr;
                }
                curr = 0;
                lastSign = ch;
            }

        }

        return solution;
    }
}