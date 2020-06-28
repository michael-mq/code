package Algorithm.LeetCode.LeetCode_239_Sliding_Window_Maximum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//        输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//        输出: [3,3,5,5,6,7]
//
//        解释过程中队列中都是具体的值，方便理解，具体见代码。
//        初始状态：L=R=0,队列:{}
//        i=0,nums[0]=1。队列为空,直接加入。队列：{1}
//        i=1,nums[1]=3。队尾值为1，3>1，弹出队尾值，加入3。队列：{3}
//        i=2,nums[2]=-1。队尾值为3，-1<3，直接加入。队列：{3,-1}。此时窗口已经形成，L=0,R=2，result=[3]
//        i=3,nums[3]=-3。队尾值为-1，-3<-1，直接加入。队列：{3,-1,-3}。队首3对应的下标为1，L=1,R=3，有效。result=[3,3]
//        i=4,nums[4]=5。队尾值为-3，5>-3，依次弹出后加入。队列：{5}。此时L=2,R=4，有效。result=[3,3,5]
//        i=5,nums[5]=3。队尾值为5，3<5，直接加入。队列：{5,3}。此时L=3,R=5，有效。result=[3,3,5,5]
//        i=6,nums[6]=6。队尾值为3，6>3，依次弹出后加入。队列：{6}。此时L=4,R=6，有效。result=[3,3,5,5,6]
//        i=7,nums[7]=7。队尾值为6，7>6，弹出队尾值后加入。队列：{7}。此时L=5,R=7，有效。result=[3,3,5,5,6,7]


public class Solution_Deque {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        if (len == 0) {
            return nums;
        }

        // deque is storing the INDICES of nums[]
        Deque<Integer> deque = new LinkedList<>();

        int[] result = new int[len - k + 1];

        for (int i = 0; i < len; i++) {
            // slide the window and poll off the head/first number's index from the window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // if the new number is larger than the tail/last number, remove the tail number's index
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // add the new number's index in the window
            deque.addLast(i);

            // ** now the number which index is the head/first element is always the biggest in the window
            // ** window size is not necessary equal `k`, it's `<= k`

            // if the window of `k` has been shaped, add the max number into result(head/first element in deque)
            // ** when `i` is less than `k - 1`, we don't start to put the index into the result array
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Deque foo = new Solution_Deque();

        int[] result = foo.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

        System.out.println(Arrays.toString(result));

        result = foo.maxSlidingWindow(new int[]{7, 2, 4}, 2);

        System.out.println(Arrays.toString(result));
    }
}
