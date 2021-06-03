package Algorithm.LeetCode.LeetCode_19_Remove_Nth_Node_From_End_of_List;

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
