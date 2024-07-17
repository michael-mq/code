package Algorithm.LeetCode.LeetCode_79_Word_Search;

class Solution2 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean helper(char[][] board, int i, int j, String word, int index) {
        if (index == word.length())
            return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j])
            return false;

        char temp = board[i][j];

        board[i][j] = '*';
        boolean found = helper(board, i, j - 1, word, index + 1)
                || helper(board, i + 1, j, word, index + 1)
                || helper(board, i, j + 1, word, index + 1)
                || helper(board, i - 1, j, word, index + 1);
        board[i][j] = temp;

        return found;
    }
}