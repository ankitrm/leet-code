package tries;

/**
 * // TODO Comment
 */
class TrieDictionary {
    private Trie trie = new Trie();

    void add(String str) {
        Trie temp = trie;
        for (char ch : str.toCharArray()) {
            temp.arr[ch - 'a'] = new Trie();
            temp = temp.arr[ch - 'a'];
        }
        temp.isWord = true;
    }

    boolean contains(String str) {
        Trie temp = trie;
        char[] ch = str.toCharArray();
        for (char ch1 : ch) {
            if (temp.arr[ch1 - 'a'] != null) {
                if (temp.arr[ch1 - 'a'].isWord) {
                    return true;
                } else {
                    temp = temp.arr[ch1 - 'a'];
                }
            } else {
                return false;
            }
        }
        return false;
    }

    private class Trie {
        Trie arr[] = new Trie[26];
        boolean isWord = false;
    }
}
