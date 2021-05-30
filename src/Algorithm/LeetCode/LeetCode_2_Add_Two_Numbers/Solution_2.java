package Algorithm.LeetCode.LeetCode_2_Add_Two_Numbers;

class Solution_2 {
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

        while(l1 != null || l2 != null) {
            ListNode temp = new ListNode();
            temp.val += move;

            int val = 0;

            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            val += move;

            if (val >= 10) {
                move = 1;
                temp.val = val % 10;
            } else {
                move = 0;
                temp.val = val;
            }

            pointer.next = temp;
            pointer = temp;
        }

        if (move == 1) {
            pointer.next = new ListNode(1);
        }

        return head.next;
    }
}
