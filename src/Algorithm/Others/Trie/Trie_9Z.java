package Algorithm.Others.Trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    // ⼦节点
    public Map<Character, TrieNode> children;
    // 根节点到该节点是否是⼀个单词
    public boolean isWord;
    // 根节点到该节点的单词是什么
    public String word;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
        word = null;
    }
}

public class Trie_9Z {
    private TrieNode root;

    public Trie_9Z() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        return root;
    }

    // 插⼊单词
    public void insert(String word) {
        TrieNode node = root;
        int L = word.length();

        for (int i = 0; i < L; i++) {
            char letter = word.charAt(i);

            if(!node.children.containsKey(letter)) {
                node.children.put(letter, new TrieNode());
            }

            node = node.children.get(letter);
        }

        node.isWord = true;
    }

    // 判断单词 word 是不是在字典树中
    public boolean hasWord(String word) {
        TrieNode node = root;
        int L = word.length();

        for (int i = 0; i < L; i++) {
            char letter = word.charAt(i);

            if (!node.children.containsKey(letter)) {
                return false;
            }

            node = node.children.get(letter);
        }

        return node.isWord;
    }

    // 判断前缀 prefix 是不是在字典树中
    public boolean hasPrefix(String word) {
        TrieNode node = root;
        int L = word.length();

        for (int i = 0; i < L; i++) {
            char letter = word.charAt(i);

            if (!node.children.containsKey(letter)) {
                return false;
            }

            node = node.children.get(letter);
        }

        return true;
    }
}
