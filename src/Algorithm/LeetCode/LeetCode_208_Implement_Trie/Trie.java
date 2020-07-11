package Algorithm.LeetCode.LeetCode_208_Implement_Trie;

import Algorithm.LeetCode.LeetCode_111_Minimum_Depth_of_Binary_Tree.TreeNode;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

public class Trie {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            int curr = word.charAt(i) - 'a';

            if (node.links[curr] == null) {
                node.links[curr] = new TrieNode();
            }

            node = node.links[curr];
        }

        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            int curr = word.charAt(i) - 'a';

            if (node.links[curr] == null) {
                return false;
            }

            node = node.links[curr];
        }

        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            int curr = prefix.charAt(i) - 'a';

            if (node.links[curr] == null) {
                return false;
            }

            node = node.links[curr];
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple")); // returns true
        System.out.println(trie.search("app")); // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app")); // returns true
    }
}
