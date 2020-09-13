package Algorithm.LeetCode.LeetCode_211_Design_Add_and_Search_Words_Data_Structure;

class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean flag;

        TrieNode() {
            children = new TrieNode[26];
            flag = false;
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        char[] array = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < array.length; i++) {
            // 当前孩子是否存在
            if (cur.children[array[i] - 'a'] == null) {
                cur.children[array[i] - 'a'] = new TrieNode();
            }
            cur = cur.children[array[i] - 'a'];
        }
        // 当前节点代表结束
        cur.flag = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the
     * dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchHelp(word, root);
    }

    private boolean searchHelp(String word, TrieNode root) {
        char[] array = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < array.length; i++) {
            // 对于 . , 递归的判断所有不为空的孩子
            if (array[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (cur.children[j] != null) {
                        if (searchHelp(word.substring(i + 1), cur.children[j])) {
                            return true;
                        }
                    }
                }

                return false;
            }
            // 不含有当前节点
            if (cur.children[array[i] - 'a'] == null) {
                return false;
            }
            cur = cur.children[array[i] - 'a'];
        }
        // 当前节点是否为是某个单词的结束
        return cur.flag;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True

        System.out.println();

        wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search(".")); // return True
        System.out.println(wordDictionary.search("a")); // return True
        System.out.println(wordDictionary.search("aa")); // return False
        System.out.println(wordDictionary.search("a")); // return True
        System.out.println(wordDictionary.search(".a")); // return False
        System.out.println(wordDictionary.search("a.")); // return False

        System.out.println();

        wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a")); // return False
        System.out.println(wordDictionary.search(".at")); // return False
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at")); // return True
        System.out.println(wordDictionary.search("an.")); // return True
        System.out.println(wordDictionary.search("a.d.")); // return False
        System.out.println(wordDictionary.search("b.")); // return False
        System.out.println(wordDictionary.search("a.d")); // return True
        System.out.println(wordDictionary.search(".")); // return False
    }
}
