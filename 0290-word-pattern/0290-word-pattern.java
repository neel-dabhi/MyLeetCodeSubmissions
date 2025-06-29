class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        String[] words = s.split(" ");

        if(pattern.length() != words.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            System.out.println(pattern.charAt(i) + " " + words[i]);

            if (!charToWord.containsKey(pattern.charAt(i))) {
                charToWord.put(pattern.charAt(i), words[i]);
            }

            if (!charToWord.get(pattern.charAt(i)).equals(words[i])) {
                return false;
            }

            if (!wordToChar.containsKey(words[i])) {
                wordToChar.put(words[i], pattern.charAt(i));
            }

            if (! wordToChar.get(words[i]).equals(pattern.charAt(i)) ){
                return false;
            }

        }
        return true;
    }
}