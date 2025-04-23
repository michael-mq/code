package Algorithm.LeetCode.LeetCode_2_Add_Two_Numbers;

class Solution_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode();
        ListNode pointer = head;

        int move = 0;

        while(l1 != null && l2 != null) {
            ListNode temp = new ListNode();

            int val = l1.val + l2.val + move;

            if (val >= 10) {
                move = 1;
                temp.val = val % 10;
            } else {
                move = 0;
                temp.val = val;
            }

            l1 = l1.next;
            l2 = l2.next;

            pointer.next = temp;
            pointer = temp;
        }

        while (l1 != null) {
            int val = l1.val + move;

            if (val >=10) {
                move = 1;
                l1.val = val % 10;
            } else {
                move = 0;
                l1.val = val;
            }

            pointer.next = new ListNode(l1.val);
            pointer = pointer.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + move;

            if (val >=10) {
                move = 1;
                l2.val = val % 10;
            } else {
                move = 0;
                l2.val = val;
            }

            pointer.next = new ListNode(l2.val);
            pointer = pointer.next;
            l2 = l2.next;
        }

        if (move == 1) {
            pointer.next = new ListNode(1);
        }

        return head.next;
    }
}
