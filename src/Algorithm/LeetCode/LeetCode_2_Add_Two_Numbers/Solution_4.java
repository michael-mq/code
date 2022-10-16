package Algorithm.LeetCode.LeetCode_2_Add_Two_Numbers;

class Solution_4 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummyHead = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int total = num1 + num2 + carry;

            head.next = new ListNode(total % 10);
            carry = total / 10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            head = head.next;
        }

        if (carry != 0) {
            head.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}