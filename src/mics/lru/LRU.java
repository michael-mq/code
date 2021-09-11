package mics.lru;

import java.util.HashMap;
import java.util.Map;

class Node<K, V> {
    K key;
    V val;

    Node<K, V> prev;
    Node<K, V> next;

    Node() {
    }

    Node(K key, V val) {
        this.key = key;
        this.val = val;

        prev = null;
        next = null;
    }
}

public class LRU<K, V> {
    Map<K, Node<K, V>> map;
    int capacity;
    Node<K, V> head;
    Node<K, V> tail;

    public LRU(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    public void put(K key, V val) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.val = val;
            moveToHead(node);
        } else {
            Node<K, V> node = new Node<>(key, val);
            map.put(key, node);
            addToHead(node);

            if (map.size() > capacity) {
                Node<K, V> last = removeTail();
                map.remove(last.key);
            }
        }
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            moveToHead(node);

            return node.val;
        }

        return null;
    }

    private void addToHead(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next .prev = node;
        head.next = node;
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    private Node<K, V> removeTail() {
        Node<K, V> node = tail.prev;
        removeNode(node);
        return node;
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
