//package Algorithm.LeetCode.LeetCode_157_Read_N_Characters_Given_Read4;
//
///**
// * The read4 API is defined in the parent class Reader4.
// *     int read4(char[] buf4);
// */
//
// https://www.youtube.com/watch?v=HcmRR2If2Hk&t=289s
//public class Solution extends Reader4 {
//    /**
//     * @param buf Destination buffer
//     * @param n   Number of characters to read
//     * @return    The number of actual characters read
//     */
//    public int read(char[] buf, int n) {
//        char[] tmp = new char[4];
//        int total = 0;
//
//        while(total < n) {
//            int count = read4(tmp);
//            count = Math.min(count, n - total);
//
//            for (int i = 0; i < count; i++) {
//                buf[total++] = tmp[i];
//            }
//
//            if (count < 4) {
//                break;
//            }
//        }
//
//        return total;
//    }
//}