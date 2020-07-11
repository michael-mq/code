package Algorithm.LeetCode.LeetCode_208_Implement_Trie;

class TrieNode {
    TrieNode[] links;
    int R = 26;
    boolean isEnd;

    TrieNode() {
        links = new TrieNode[R];
    }
}
