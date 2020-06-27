package Algorithm.LeetCode.LeetCode_25_ReverseNodesInKGroup;

// https://leetcode.com/problems/swap-nodes-in-pairs/discuss/11030/My-accepted-java-code.-used-recursion
// AND https://leetcode.com/articles/reverse-linked-list/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }

        ListNode curr = head;
        int count = 0;

        // move curr to the end of current loop
        // if the current loop is less than k, then no need to reverse, just return
        // * important, make sure count == k
        do {
            if (curr == null) {
                return head;
            }
            curr = curr.next;
            count++;
        }
        while (count < k);

        // do next round of loop via recursion
        curr = reverseKGroup(curr, k);

        // when the result is returned from next recursion
        // reverse nodes in the current loop
        // standard reverse
        while (count-- > 0) {
            ListNode temp = head.next;
            head.next = curr;
            curr = head;
            head = temp;
        }

        return curr;
    }

    public static void main(String[] args) {
        Solution foo = new Solution();

        ListNode result, head;

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        result = foo.reverseKGroup(head, 3);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        result = foo.reverseKGroup(head, 2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }


}
