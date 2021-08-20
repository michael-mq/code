package mics.stack;

import java.util.Arrays;

public class MyStack<T> {
    private static final int INITIAL_CAPACITY = 10;
    private int capacity;
    private T[] arr;
    private int top;

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
        top = -1;
    }

    public void push(T value) {
        if (isFull()) {
            extendCapacity();
        }

        arr[++top] = value;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        return arr[top--];
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    private boolean isEmpty() {
        return top < 0;
    }

    private boolean isFull() {
        return top == capacity - 1;
    }

    private void extendCapacity() {
        T[] newArr = Arrays.copyOf(arr, arr.length + INITIAL_CAPACITY);
        this.arr = newArr;
    }
}
