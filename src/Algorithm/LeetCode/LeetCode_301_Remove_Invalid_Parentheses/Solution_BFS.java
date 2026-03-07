package Algorithm.LeetCode.LeetCode_301_Remove_Invalid_Parentheses;

import java.util.*;

class Solution_BFS {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                // 如果当前字符串合法
                if (isValid(curr)) {
                    res.add(curr);
                    found = true;
                }

                // 如果已经找到了最少删除的层，不再生成下一层
                if (found) continue;

                // 生成下一层：尝试删除每一个括号
                for (int j = 0; j < curr.length(); j++) {
                    char c = curr.charAt(j);
                    if (c != '(' && c != ')') continue;

                    String next = curr.substring(0, j) + curr.substring(j + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            // 只要在这一层找到了结果，就直接跳出，保证“最少删除”
            if (found) break;
        }

        return res;
    }

    // 辅助函数：检查括号合法性
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}