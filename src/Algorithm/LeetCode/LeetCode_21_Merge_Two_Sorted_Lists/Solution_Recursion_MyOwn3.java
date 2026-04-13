package Algorithm.LeetCode.LeetCode_21_Merge_Two_Sorted_Lists;

class Solution_Recursion_MyOwn3 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode();

        if (list1.val <= list2.val) {
            head = list1;
            list1.next = mergeTwoLists(list1.next, list2);
        } else {
            head = list2;
            list2.next = mergeTwoLists(list1, list2.next);
        }

        return head;
    }
}