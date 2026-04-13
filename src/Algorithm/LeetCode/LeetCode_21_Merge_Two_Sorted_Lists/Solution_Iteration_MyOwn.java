package Algorithm.LeetCode.LeetCode_21_Merge_Two_Sorted_Lists;


public class Solution_Iteration_MyOwn {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode dumb = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            } else {
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }
        }

        if (list1 == null) {
            head.next = list2;
        }

        if (list2 == null) {
            head.next = list1;
        }

        return dumb.next;
    }
}
