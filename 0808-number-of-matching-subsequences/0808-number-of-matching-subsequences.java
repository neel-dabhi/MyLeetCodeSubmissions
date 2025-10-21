class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;

        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new ArrayList<>());
            }
            List<Integer> indexes = map.get(ch);
            indexes.add(i);
            map.put(ch, indexes);
        }
        HashSet<String> set = new HashSet<>();

        for (String word : words) {
            if (set.contains(word)) {
                result++;
                continue;
            }
            if (isSubSequence(word, map)) {
                result++;
                set.add(word);
            }
        }

        return result;
    }

    private boolean isSubSequence(String word, HashMap<Character, List<Integer>> map) {
        int last = -1;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!map.containsKey(ch)) {
                return false;
            }

            int nextIndex = binarySearch(map.get(ch), last);

            if (nextIndex == -1) {
                return false;
            }
            last = nextIndex;
        }
        return true;
    }

    private int binarySearch(List<Integer> positions, int last) {

        int low = 0;
        int high = positions.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (positions.get(mid) > last) {
                ans = positions.get(mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}