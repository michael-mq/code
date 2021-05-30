package Algorithm.LeetCode.LeetCode_2_Add_Two_Numbers;

class Solution_3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode();
        ListNode curr = head;

        int carry = 0;

        while(l1 != null || l2 != null) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(1);
        }

        return head.next;
    }
}
