class Solution {
    class TrieNode {
        boolean isEnding = false;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        for(String word : dictionary){
            insertToTrie(word);
        }

        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();
        for(String word : words){
            result.append(findFirstPreFix(word));
            result.append( " ");
        }
        return result.toString().trim();
    }

    private void insertToTrie(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {

            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnding = true;
    }

    private String findFirstPreFix(String word){
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();

        for(char ch: word.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                return word;
            }
            curr = curr.children[ch - 'a'];
            prefix.append(ch);

            if( curr.isEnding == true){
                return prefix.toString();
            }
            
        }

        return word;
    }
}