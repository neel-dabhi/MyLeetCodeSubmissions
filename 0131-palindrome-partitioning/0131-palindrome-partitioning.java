class Solution {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList<List<String>>();
        helper(s, 0, new ArrayList<>());

        return result;
    }

    private void helper(String s, int index, List<String> path) {
        // base
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);

            if (isPalindrome(substring)) {
                path.add(substring);
                helper(s, i + 1, path);
                path.remove(path.size() -1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }
}