package Algorithm.LeetCode.LeetCode_71_Simplify_Path;

import java.util.Arrays;
import java.util.Stack;

public class Solution2 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // 以 / 分割路径并存储到 str 字符串数组中
        String[] str = path.split("/");

        for (int i = 0; i < str.length; i++) {
            // 除去每个字符串两边的空格
            String cur = str[i].trim();
            if (cur == null || cur.length() == 0 || cur.equals(".")) {
                continue;
            }
            if (cur.equals("..")) {
                // 必须要判断栈是否为空
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(cur);
            }
        }

        String ans = "";
        // 巧妙的反向构建结果
        while (!stack.isEmpty()) {
            ans = "/" + stack.pop() + ans;
        }
        // 最后还要判断是否为空
        return ans.length() == 0 ? "/" : ans;
    }

    public static void main(String[] args) {
        Solution2 foo = new Solution2();

        System.out.println(foo.simplifyPath("/home/"));

        System.out.println(Arrays.toString("/1/2/3/4/".split("/")));
    }
}
