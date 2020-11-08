package Algorithm.LeetCode.LeetCode_636_Exclusive_Time_of_Functions;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        String[] s = logs.get(0).split(":");
        stack.push(Integer.valueOf(s[0]));
        int prev = Integer.valueOf(s[2]);

        for (int i = 1; i < logs.size(); i++) {
            s = logs.get(i).split(":");
            int id = Integer.valueOf(s[0]);
            String status = s[1];
            int time = Integer.valueOf(s[2]);

            if (status.equals("start")) {
                if (!stack.isEmpty()) {
                    int index = stack.peek();
                    res[index] += time - prev;
                }

                prev = time;
                stack.push(id);
            } else {
                int index = stack.pop();
                res[index] += time - prev + 1;
                prev = time + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution foo = new Solution();

        List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        System.out.println(Arrays.toString(foo.exclusiveTime(2, logs)));

        logs = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");
        System.out.println(Arrays.toString(foo.exclusiveTime(1, logs)));

        logs = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7");
        System.out.println(Arrays.toString(foo.exclusiveTime(2, logs)));

        logs = Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8");
        System.out.println(Arrays.toString(foo.exclusiveTime(2, logs)));

        logs = Arrays.asList("0:start:0","0:end:0");
        System.out.println(Arrays.toString(foo.exclusiveTime(1, logs)));
    }
}
