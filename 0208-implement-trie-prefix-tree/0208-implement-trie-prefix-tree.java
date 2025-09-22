class TreeNode{
    boolean isEnd;
    TreeNode[] children;

    TreeNode(){
        isEnd = false;
        children = new TreeNode[26];
    }
}

class Trie {
    TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {

        if (!word.isEmpty()) {
            TreeNode curr = root;

            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TreeNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
        }

    }

    public boolean search(String word) {

        if (word.isEmpty()) {
            return false;
        }
        TreeNode curr = root;

        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {

        if (prefix.isEmpty()) {
            return false;
        }

        TreeNode curr = root;
        for (char ch : prefix.toCharArray()) {

            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */