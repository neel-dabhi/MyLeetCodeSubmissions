class Solution {
    public List<String> removeAnagrams(String[] words) {

        ArrayList<String> result = new ArrayList<>();
        String last = "";

        for (String word : words) {
            if (result.size() > 0 && isAnagram(last, word)) {
                continue;
            }
            last = word;
            result.add(word);
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