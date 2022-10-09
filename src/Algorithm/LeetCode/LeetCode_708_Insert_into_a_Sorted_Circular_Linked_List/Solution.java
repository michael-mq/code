package Algorithm.LeetCode.LeetCode_708_Insert_into_a_Sorted_Circular_Linked_List;

// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);

        if (head == null) {
            node.next = node;

            return node;
        }

        Node cur = head;

        while (cur.next != head) {
            if (cur.val <= insertVal && insertVal <= cur.next.val) {
                break;
            } else if (cur.val > cur.next.val && (cur.next.val > insertVal || cur.val < insertVal)) {
                break;
            }

            cur = cur.next;
        }

        Node temp = cur.next;
        cur.next = node;
        node.next = temp;

        return head;
    }
}