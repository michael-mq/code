package Algorithm.LeetCode.LeetCode_212_Word_Search_II;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 implements Serializable {
    class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode cur = root;

            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }

                cur = cur.children[c - 'a'];
            }

            cur.word = word;
        }

        return root;
    }


    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {
        char c = board[i][j];

        if (c == '#') {
            return;
        }

        root = root.children[c - 'a'];

        if (root == null) {
            return;
        }

        if (root.word != null) {
            result.add(root.word);
            root.word = null;

            return;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = board.length;
        int n = board[0].length;

        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] != '#') {
                dfs(board, x, y, root, result);
            }
        }

        board[i][j] = temp;
    }

    public static void main(String[] args) {
        Solution2 foo = new Solution2();

        char[][] board = new char[][]{
                {'a'}
        };

        String[] words = new String[]{"a"};

        List<String> result = foo.findWords(board, words);

        System.out.println(Arrays.toString(result.toArray()));
    }
}
