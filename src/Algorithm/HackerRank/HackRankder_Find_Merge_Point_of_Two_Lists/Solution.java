package Algorithm.HackerRank.HackRankder_Find_Merge_Point_of_Two_Lists;

import java.io.BufferedWriter;
import java.io.IOException;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int len1 = 0;
        int len2 = 0;

        SinglyLinkedListNode node1 = head1;
        SinglyLinkedListNode node2 = head2;

        while (node1 != null) {
            len1++;
            node1 = node1.next;
        }

        while (node2 != null) {
            len2++;
            node2 = node2.next;
        }

        int diff = Math.abs(len1 - len2);

        node1 = head1;
        node2 = head2;

        if (len1 > len2) {
            for (int i = 0; i < diff; i++) {
                node1 = node1.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                node2 = node2.next;
            }
        }

        while (node1.next != null) {
            if (node1 == node2) {
                return node1.data;
            }

            node1 = node1.next;
            node2 = node2.next;
        }

        return node1.data;

    }
}
