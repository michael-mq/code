package Algorithm.LeetCode.LeetCode_247_StrobogrammaticNumbers;

import java.util.*;

class StrobogrammaticNumbers {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    List<String> helper(int n, int m) {
        // 第一步：判断输入或者状态是否非法？
        if (n < 0 || m < 0 || n > m) {
            throw new IllegalArgumentException("invalid input");
        }

        // 第二步：判读递归是否应当结束?
        if (n == 0)
            return new ArrayList<String>(Arrays.asList(""));
        if (n == 1)
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));

        // 第三步：缩小问题规模
        List<String> list = helper(n - 2, m);

        // 第四步: 整合结果
        List<String> res = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            if (n != m)
                res.add("0" + s + "0");

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }

        return res;
    }
}

class StrobogrammaticNumbersMain {
    public static void main(String[] args) {
        StrobogrammaticNumbers strobogrammaticNumbers = new StrobogrammaticNumbers();

        System.out.println(strobogrammaticNumbers.findStrobogrammatic(4));
    }
}