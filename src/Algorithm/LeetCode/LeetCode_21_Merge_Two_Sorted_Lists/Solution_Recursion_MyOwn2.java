package Algorithm.LeetCode.LeetCode_21_Merge_Two_Sorted_Lists;

class Solution_Recursion_MyOwn2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode();

        if (list1.val < list2.val) {
            dummy.next = list1;
            list1.next = mergeTwoLists(list1.next, list2);
        } else {
            dummy.next = list2;
            list2.next = mergeTwoLists(list1, list2.next);
        }

        return dummy.next;
    }
}