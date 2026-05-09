package Algorithm.LeetCode.LeetCode_138_Copy_List_with_Random_Pointer;/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;
import java.util.Map;

class Solution_Iteration_MyOwn {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node cloneHead = new Node(head.val);
        cloneHead.random = head.random;

        map.put(head, cloneHead);

        Node dummy = cloneHead;

        Node next = head.next;

        while (next != null) {
            Node cloneNext = new Node(next.val);
            cloneNext.random = next.random;

            map.put(next, cloneNext);

            cloneHead.next = cloneNext;
            cloneHead = cloneNext;

            next = next.next;
        }

        Node node = dummy;

        while (node != null) {
            node.random = map.get(node.random);
            node = node.next;
        }

        return dummy;
    }
}