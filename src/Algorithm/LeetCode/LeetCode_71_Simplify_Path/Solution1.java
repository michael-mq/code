package Algorithm.LeetCode.LeetCode_71_Simplify_Path;

import java.util.Stack;

public class Solution1 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // 首先将字符串以 “/” 分隔存储到新的字符数组 str 中
        String[] str = path.split("/");
        for (String s : str) {
            // 如果访问到的是 “..” 则说明要返回上一级,要将当前元素出栈
            if (s.equals("..") ) {
                // 还需判断栈是否为空,否则会报错
                if (!stack.isEmpty() ) {
                    stack.pop();
                }
                // 如果数组非空并且当前元素不是 “.” 说明当前元素是路径信息，要入栈
            } else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }
        // 如果栈内没有元素说明没有路径信息，返回 “/” 即可
        if (stack.isEmpty()) {
            return "/";
        }
        // 这里用到 StringBuilder 操作字符串，效率高
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            // 这里从栈底开始拿元素
            ans.append( "/" + stack.get(i) );
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution1 foo = new Solution1();

        System.out.println(foo.simplifyPath("/home/"));
    }
}
