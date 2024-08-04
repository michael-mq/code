package Algorithm.LeetCode.LeetCode_91_Decode_Ways;
// https://leetcode-cn.com/problems/decode-ways/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/

//用一个 dp 数组， dp [ i ] 代表字符串 s [ i, s.len-1 ]，也就是 s 从 i 开始到结尾的字符串的解码方式。
//这样和递归完全一样的递推式。
//如果 s [ i ] 和 s [ i + 1 ] 组成的数字小于等于 26，那么
//dp [ i ] = dp[ i + 1 ] + dp [ i + 2 ]

class DecodeWaysDP1 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        //将递归法的结束条件初始化为 1
        dp[len] = 1;
        //最后一个数字不等于 0 就初始化为 1
        dp[len - 1] = s.charAt(len - 1) == 0 ? 0 : 1;

        for (int i = len - 2; i >= 0; i--) {
            //当前数字时 0 ，直接跳过，0 不代表任何字母
            if (s.charAt(i) == '0') {
                continue; // so the dp[i] will be 0
            }
            int ans1 = dp[i + 1];
            //判断两个字母组成的数字是否小于等于 26

            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';

            if (ten + one <= 26) {
                ans2 = dp[i + 2];
            }

            dp[i] = ans1 + ans2;
        }

        return dp[0];
    }
}

class DecodeWaysDP1Main {
    public static void main(String[] args) {
        DecodeWaysDP1 decodeWays = new DecodeWaysDP1();

        System.out.println(decodeWays.numDecodings("2206"));
    }
}
