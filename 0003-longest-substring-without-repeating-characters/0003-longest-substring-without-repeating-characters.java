class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right < s.length()) { // abcabcbb
            Character currChar = s.charAt(right); // a,b
    
            if (map.containsKey(currChar) && left <= map.get(currChar)) {
                left = map.get(currChar) + 1;
            } 
            map.put(currChar, right);
            right++;
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}