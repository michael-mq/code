package Algorithm.Others.Heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class ValueIndexPair {
    int val;
    int index;

    public ValueIndexPair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

public class MeanHeapWithLazyDeletion_9Z {
    private Queue<ValueIndexPair> minHeap;
    private Set<Integer> deleteSet;

    public MeanHeapWithLazyDeletion_9Z() {
        minHeap = new PriorityQueue<>((p1, p2) -> p1.val - p2.val);
        deleteSet = new HashSet<>();
    }

    public void push(int index, int val) {
        minHeap.add(new ValueIndexPair(index, val));
    }

    public void delete(int index) {
        deleteSet.add(index);
    }

    public void lazyDeletion() {
        while (!minHeap.isEmpty() && deleteSet.contains(minHeap.peek().index)) {
            ValueIndexPair pair = minHeap.poll();
            deleteSet.remove(pair.index);
        }
    }

    public ValueIndexPair peek() {
        lazyDeletion();
        return minHeap.peek();
    }

    public ValueIndexPair pop() {
        lazyDeletion();
        return minHeap.poll();
    }

    public boolean isEmpty() {
        return minHeap.isEmpty();
    }
}
