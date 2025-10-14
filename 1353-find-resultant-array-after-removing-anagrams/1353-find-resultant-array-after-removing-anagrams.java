class Solution {
    public List<String> removeAnagrams(String[] words) {
        Stack<String> st = new Stack<>();

        for (String word : words) {
            if (!st.isEmpty() && isAnagram(st.peek(), word)) {
                continue;
            }
            st.push(word);
        }

        ArrayList<String> result = new ArrayList<>();

        while (!st.isEmpty()) {
            result.add(0, st.pop());
        }
        return result;
    }

    private boolean isAnagram(String a, String b) {

        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        Arrays.sort(aArray);
        Arrays.sort(bArray);

        String aString = new String(aArray);
        String bString = new String(bArray);

        return aString.equals(bString);
    }
}