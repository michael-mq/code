package Algorithm.LeetCode.LeetCode_91_Decode_Ways;
// https://leetcode-cn.com/problems/decode-ways/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/

//                                        23223
//                              /                       \
//                             2            +           2,3
//                       /             \             /         \
//                      3              3,2          2         2,2
//                   /     \          /    \       /  \        /
//                  2       2,2     2      2,3    2   2,3     3
//                 /  \     /      /             /
//                2   2,3  3      3             3
//               /
//              3

// for 23223, when the number is 2(index 0), answer depends on the next number 3(index 1) and 32(index 2)

class DecodeWaysRecursion2 {
    public int numDecodings(String s) {
        return getAns(s, 0);
    }

    private int getAns(String s, int start) {
        //划分到了最后返回 1
        if (start == s.length()) {
            return 1;
        }
        //开头是 0,0 不对应任何字母，直接返回 0
        if (s.charAt(start) == '0') {
            return 0;
        }
        //得到第一种的划分的解码方式
        int ans1 = getAns(s, start + 1); // take 2(index 0), the answer is depending on 3(index 1)
        int ans2 = 0;
        //判断前两个数字是不是小于等于 26 的
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, start + 2); // take 23(index 0,1), the answer is depending on 2(index 2)
            }
        }
        return ans1 + ans2;
    }
}

class DecodeWaysRecursion2Main {
    public static void main(String[] args) {
        DecodeWaysRecursion2 decodeWays = new DecodeWaysRecursion2();

        System.out.println(decodeWays.numDecodings("226"));
    }
}
