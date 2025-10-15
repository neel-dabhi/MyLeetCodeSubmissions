class Solution {
    public int minTimeToType(String word) {
        int time = 0;
        char curr = 'a';
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            time = time + Math.min(Math.abs(ch - curr), 26 - Math.abs(ch - curr)) + 1;
            curr = ch;
        }
        return time;
    }
}