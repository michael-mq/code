///**
// * The read4 API is defined in the parent class Reader4.
// * int read4(char[] buf4);
// */
//
//// https://www.youtube.com/watch?v=w3ke3MQTEJ8
//public class Solution extends Reader4 {
//    /**
//     * @param buf Destination buffer
//     * @param n   Number of characters to read
//     * @return The number of actual characters read
//     */
//
//    private int ptr4 = 0;
//    private int cnt4 = 0;
//    private char[] buf4 = new char[4];
//
//    public int read(char[] buf, int n) {
//        int total = 0;
//
//        while (total < n) {
//            if (ptr4 == 0) {
//                cnt4 = read4(buf4);
//            }
//
//            if (cnt4 == 0) {
//                break;
//            }
//
//            while (total < n && ptr4 < cnt4) {
//                buf[total++] = buf4[ptr4++];
//            }
//
//            if (ptr4 >= cnt4) {
//                ptr4 = 0;
//            }
//        }
//
//        return total;
//    }
//}