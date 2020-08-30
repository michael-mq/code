package Algorithm.LeetCode.LeetCode_141_Linked_List_Cycle;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this(val, null);
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
