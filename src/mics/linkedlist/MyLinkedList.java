package mics.linkedlist;

public class MyLinkedList<T> {
    class Node {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }

    private Node head;
    private Node last;
    private int size;

    public MyLinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    public void add(T value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            last = head;
        } else {
            last.next = node;
            last = last.next;
        }

        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node cur = head;

        for (int i = 1; i <= index; i++) {
            cur = cur.next;
        }

        return cur.value;
    }

    public void remove(int index) {
        if (size == 0 || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == 1) {
            head = null;
            last = null;
            size = 0;
            return;
        }

        Node cur = head;
        Node pre = head;
        int cnt = 0;

        while (cnt != index) {
            pre = cur;
            cur = cur.next;
            cnt++;
        }

        pre.next = cur.next;

        if (index == size - 1) {
            last = pre;
        }

        size--;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        Node cur = head;

        while (cur != null) {
            sb.append(cur.value.toString());
            cur = cur.next;
        }

        return sb.toString();
    }

    public Node getHead() {
        return head;
    }

    public Node getLast() {
        return last;
    }

    public int size() {
        return size;
    }
}
