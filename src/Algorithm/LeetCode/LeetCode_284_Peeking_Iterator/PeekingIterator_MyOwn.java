package Algorithm.LeetCode.LeetCode_284_Peeking_Iterator;// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class PeekingIterator_MyOwn implements Iterator<Integer> {
    private List<Integer> list;
    private int pointer;

    public PeekingIterator_MyOwn(Iterator<Integer> iterator) {
        // initialize any member here.
        list = new LinkedList<>();

        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        pointer = -1;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(pointer + 1);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        pointer++;
        return list.get(pointer);
    }

    @Override
    public boolean hasNext() {
        return list.size() == pointer + 1;
    }
}
