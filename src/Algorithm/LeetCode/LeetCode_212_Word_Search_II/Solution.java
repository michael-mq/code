package Algorithm.LeetCode.LeetCode_212_Word_Search_II;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution implements Serializable {
    public class TrieNode {
        String word;
        TrieNode[] links = new TrieNode[26];
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];

        // important, this is the ending/returning condition
        // either current character in board has already been checked
        // or the word in trie has reached the end
        if (c == '#' || p.links[c - 'a'] == null) {
            return;
        }

        // otherwise check the next character in tire
        p = p.links[c - 'a'];

        // if it reached a full word
        if (p.word != null) {
            res.add(p.word);
            // we don't need to check this word anymore
            p.word = null;
        }

        // temporarily mark the character as `#` which will be recovered after current round of dfs searching checking
        board[i][j] = '#';

        if (i > 0) {
            dfs(board, i - 1, j, p, res);
        }

        if (j > 0) {
            dfs(board, i, j - 1, p, res);
        }

        if (i < board.length - 1) {
            dfs(board, i + 1, j, p, res);
        }

        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, p, res);
        }

        // backtracking, recover the original character
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String w : words) {
            TrieNode p = root;

            for (char c : w.toCharArray()) {
                if (p.links[c - 'a'] == null) {
                    p.links[c - 'a'] = new TrieNode();
                }
                p = p.links[c - 'a'];
            }

            p.word = w;
        }

        return root;
    }

    public static void main(String[] args) {
        Solution foo = new Solution();

        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

//        List<String> words = new ArrayList<>(Arrays.asList("oath", "pea", "eat", "rain"));
        String[] words = {"oath", "pea", "eat", "rain"};

        List<String> result = foo.findWords(board, words);

        System.out.println(Arrays.toString(result.toArray()));
    }
}
