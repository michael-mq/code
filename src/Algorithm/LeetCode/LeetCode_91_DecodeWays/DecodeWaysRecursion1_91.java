package Algorithm.LeetCode.LeetCode_91_DecodeWays;//https://kaiwu.lagou.com/course/courseInfo.htm?sid=&courseId=3&lagoufrom=noapp#/detail/pc?id=32

class DecodeWaysRecursion1 {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        char[] chars = s.toCharArray();
        return decode(chars, chars.length - 1);
    }

    public int decode(char[] chars, int index) {
        if (index <= 0) return 1;

        int ans1 = 0, ans2 = 0;

        char curr = chars[index];
        char prev = chars[index - 1];

        if (curr > '0') {
            ans1 = decode(chars, index - 1);
        }

        if (prev == '1' || (prev == '2' && curr <= '6')) {
            ans2 = decode(chars, index - 2);
        }

        return ans1 + ans2;
    }
}

class DecodeWaysRecursion1Main {
    public static void main(String[] args) {
        DecodeWaysRecursion1 decodeWays = new DecodeWaysRecursion1();

        System.out.println(decodeWays.numDecodings("226"));
    }
}
