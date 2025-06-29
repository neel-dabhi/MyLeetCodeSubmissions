class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        count.put('a', 0);
        count.put('b', 0);
        count.put('c', 0);

        int result = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count.put(ch, count.get(ch) + 1);
            
            while(count.get('a') > 0 &&
                    count.get('b') > 0 &&
                    count.get('c') > 0) {

                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar) - 1);
                left++;
                result = result + s.length() - i;
            }

        }

        return result;
    }
}