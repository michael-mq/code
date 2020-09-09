package Algorithm.LeetCode.LeetCode_394_Decode_String;

import java.util.Stack;

// https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
class Solution_Stack {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;

        Stack<Integer> stack_multi = new Stack<>();
        Stack<String> stack_res = new Stack<>();

        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.push(multi); // push number
                stack_res.push(res.toString()); // push previous string

                multi = 0; // clear number
                res = new StringBuilder(); // clear string
            }
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();

                int cur_multi = stack_multi.pop(); // pop latest number

                for(int i = 0; i < cur_multi; i++) { // number multiply strings inside []
                    tmp.append(res);
                }

                res = new StringBuilder(stack_res.pop() + tmp); // previous sting + repeated string
            }
            else if(c >= '0' && c <= '9') { // increase the digit of number
                multi = multi * 10 + Integer.parseInt(c + ""); // Integer.parseInt(String.valueOf(c)) or (c - '0')
            }
            else { // when it's a normal letter
                res.append(c);
            }
        }

        return res.toString();
    }
}
